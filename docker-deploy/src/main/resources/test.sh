#!/bin/bash -x

set +x
function compileMicroService(){
serviceName=$1
workspacePath="$WORKSPACE/$project/engineering-ability"

if [ "X$tag" = "X" ]; then
tag="latest"
fi

cd $WORKSPACE/$project/$serviceName
lastCommitTime=$(git log -l --pretty=format: "%cd" --date=iso)
projectVersion=$(mvn -q Dexec.executable=echo -Dexec.args='${project.version}' --non-recursive exec:exec)
dockerServiceName=$(translateService ${serviceName} ${workspacePath})
if [ "X$dockerServiceName" = "X" ]; then
echo "[ERROR] fail to get docker service name"
exit 1
fi

echo "[INFO] the current docker serviceName: $dockerServiceName"

compileAngular ${serviceName}

compileMaven ${serviceName}

tarFiles ${serviceName}

modifyDockerfile ${serviceName} ${lastCommitTime} ${projectVersion}

buildImage ${serviceName} ${dockerServiceName}
}

function compileAngular(){
serviceName=$1
if [ ! -d 'angular' ]; then
  cd $WORKSPACE/$project/$serviceName/angular
  echo "[INFO] start to config npm"
  npm --registry ${adcRegistry} install adc-widget
  npm config set registry $cmcRegistry
  npm uninstall -g @angular/cli #写在较旧的angular-cli版本

  npm install ==unsafe-perm --allow-root
  echo "[INFO] start to npm compile: $(date)"
  node ./node_modules/@angular/cli/bin/ng version
  node --max_old_space_size=8192 ./node_modules/@angular/cli/bin/ng build --aot --prod
  if [ $? != "0" ]; then
    echo "[ERROR] npm compile failed"
    exit 1
  fi
  echo "[INFO]compile angular project successfully: $(date)"
else
  echo "[INFO]not a angular project"
fi
}

function compileMaven(){
serviceName=$1
#delete the local application.yml
rm -rf cd $WORKSPACE/$project/$serviceName/config
cd $WORKSPACE/$project/$serviceName
mvn clean -U package -Dmaven.test.skip=true
cd $WORKSPACE/$project/$serviceName/target/
packageName=$(ls | grep *.tar.gz)
echo "[INFO] package name is: ${packageName}"
mv ${packageName} $WORKSPACE/$project/$serviceName/target/classes/
echo "[INFO] compile maven project successfully"
}

# docker image中需要的文件，打成包一次ADD添加进去
function tarFiles(){
serviceName=$1
file_dir="$WORKSPACE/$project/adc-k8s-helm"
cd $WORKSPACE/$project/$serviceName/target/classes/
mkdir app
mkdir -p app/bin app/template app/template/config app/lib app/lib/config app/certs app/tools app/conf
cp -f ${file_dir}/dockerfiles/bin/* app/bin  #拷贝容器entrypoint.sh脚本
cp -f  ${file_dir}/dockerfiles/templates/application.yml app/template/config  #各个微服务公共spring配置文件

#k8s部署，application.yml中抽取的config_map secret项
cp -f  ${file_dir}/dockerfiles/templates/${serviceName}/* app/template
cp -f  ${file_dir}/dockerfiles/conf/${serviceName}/* app/conf   #各个微服务独有的spring配置文件
cp $WORKSPACE/$project/$serviceName/target/*.jar app/lib  #微服务可执行Jar包

# 打包
tar -cvzf files.tar.gz app
}

function modifyDockerfile(){
serviceName=$1
lastCommitTime=$2
projectVersion=$3

dockerfileName="dockerfile"

cd $WORKSPACE/$project/$serviceName/target/classes
if [ ! -f ${dockerFileName} ]; then
  echo "[INFO] dockerfile does exist"
  exit 1
fi

jdkImage="docker_repositry_com\/bes-commerce\/bac\/jdk1.8.0_${jdk_version}:${jdkImageVersion}"
sed -i "s/^FROM.*/FROM $jdkImage/" ${dockerfileName}
sed -i "s/^ENTRYPOINT.*nolock/ENTRYPOINT umask 0077/" ${dockerfileName}
sed -i "s/--spring.profiles.active=sentinel/--spring.profiles.active=redis/" ${dockerfileName}

versionDate=$(date +%Y%m%d)
echo "" >>${dockerfileName}
echo "ENV BRANCH_NAME #codeBranch" >>${dockerfileName}
echo "ENV VERSION_DATE ${versionDate}" >>${dockerfileName}
echo "ENV LAST_COMMIT_TIME ${lastCommitTime}" >>${dockerfileName}
echo "LABEL PROJECT_VERSION ${projectVersion}" >>${dockerfileName}
}

function buildImage(){
serviceName=$1
dockerServiceName=$2

cd $WORKSPACE/$project/$serviceName/target/classes
set +e
docker rmi -f $(docker images -q -f dangling=true)
set -e

serviceImageUrl="${dockerHub}/${stage}/$dockerServiceName:${tag}"
echo "[INFO] service image address: ${serviceImageUrl}"
docker login -u ${account} -p ${password} ${dockerHub}
docker build -t ${serviceImageUrl} ./
docker push ${serviceImageUrl}
echo "[INFO] build and push image ${serviceImageUrl} finished"
}