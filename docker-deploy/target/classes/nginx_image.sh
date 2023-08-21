#!/bin/bash

set -ex

function export_env(){
export workspace=${CID_WORKSPACE}
serviceName="nginx"
imagesHome=${workspace}/.cid/images
service_version=${VERSION}_${CID_BUILD_TIME}
third_dir="/home/service/third_dir"
third_dir_name="third_dir"
nginx_version="nginx-1.22.0-1.el8.ngx"
}

function tar_files(){
cd ${workspace}
package_floder=${imagesHome}/${serviceName}
rm -rf ${package_floder}
mkdir -p ${package_floder}

cp -r ${workspace}/.cid/deployment/release/bin ${package_floder}/
cp -r ${workspace}/.cid/deployment/release/config/nginx.conf ${package_floder}/
cp -r ${workspace}/.cid/deployment/release/config/scc.conf ${package_floder}/

cd ${imagesHome}
tar -cvzf ${serviceName}.tar.gz ${serviceName}
}

function prepare_euler_yum(){
cat <<END >/etc/yum.repos.d/EulerOS.repo
[base]
name=EulerOS-2.0SP8 base
baseurl=http://mirrors.tools.huawei.com/euler/2.8/os/aarch64/
enabled=1
gpgcheck=1
gpgkey=http://mirrors.tools.huawei.com/euler/2.8/os/RPM-GPG-KEY-Euler-OS
END

cp -f /etc/yum.repos.d/EulerOS.repo $imagesHome
}

#nginx源码编译时依赖的软件
function prepare_compile_dependency(){
pcre2="pcre-10.32-2.el8"
pcre2_utf16="pcre-utf16-10.32-2.el8"
pcre2_utf32="pcre-utf32-10.32-2.el8"
pcre2_devel="pcre-devel-10.32-2.el8"
nginx_src="nginx-1.22.0-1.el8.ngx-src"

softwares=(
${pcre2}
${pcre2_utf16}
${pcre2_utf32}
${pcre2_devel}
)
yum makecache
for software in ${softwares}; do
yum -y install --downloadonly --downloaddir=${imagesHome}/ --enablerepo=opensource ${software}
done
yumdownloader --downloadonly --destdir ${imagesHome}/ --enablerepo=opensource ${nginx_src}
}


#nginx安装时的依赖软件
function prepare_install_dependecy(){
yum makecache
yum install -y --enablerepo=opensource yum-utils

make="make-4.2.1-10.el8"
compat_openssl10="compat-openssl10-1.0.2o-3.el8"
yumdownloader --downloadonly --enablerepo=opensource --destdir ${imagesHome}/ make
yumdownloader --downloadonly --enablerepo=opensource --destdir ${imagesHome}/ compat-openssl10
}

#编译Nginx源码
function make_nginx_rpm(){
prepare_compile_dependency

yum clean all
yum makecache
yum install -y --enablerepo=base gcc gcc-c++ pcre libpcre2 zlib zlib-devel openssl openssl-devel yum-utils ncurses-devel perl rpm-build

#手动安装nginx依赖的，而yum源中没有的软件
rpm -ivh ${imagesHome}/${pcre2}.x86_64.rpm
rpm -ivh ${imagesHome}/${pcre2_utf16}.x86_64.rpm
rpm -ivh ${imagesHome}/${pcre2_utf32}.x86_64.rpm
rpm -ivh ${imagesHome}/${pcre2_devel}.x86_64.rpm
rpm -ivh ${imagesHome}/${nginx_src}.x86_64.rpm

rpmbuild_dir=/root/rpmbuild
ls -al ${rpmbuild_dir}
rm -f ${rpmbuild_dir}/SPECS/nginx.spec
cp -f ${imagesHome}/nginx.spec ${rpmbuild_dir}/SPECS
rpmbuild -bb ${rpmbuild_dir}/SPECS/nginx.spec
ls -al ${rpmbuild_dir}/RPMS

nginx_rpm=$(ls ${rpmbuild_dir}/RPMS/x86_64 | grep "nginx-1*" | head -n 1)
export NGINX_RPM=${nginx_rpm}
cp -f ${rpmbuild_dir}/RPMS/x86_64/${NGINX_RPM} ${imagesHome}/
}

function prepare_nginx_rpm(){
prepare_euler_yum

# 准备nginx rpm包，先从fuxi下载，没有则下载源码编译
nginx_1_22=$(yum list --enablerepo=opensource --showdumplicate | grep "nginx-1.22.0-1.el7.ngx" | head -n 1)
if [ -n ${nginx_1_22} ]; then
yumdownloader --downloadonly --enablerepo=opensource --destdir ${imagesHome}/ "nginx-1.22.0-1.el7.ngx"
export NGINX_RPM="nginx-1.22.0-1.el7.ngx.x86_64.rpm"
else
echo "[INFO] there is no nginx-1.22 rpm. now it get one by compiling"
make_nginx_rpm
fi

if [ ! -e ${imagesHome}/${NGINX_RPM} ]; then
echo "[ERROR] there is no nginx rpm in this machine"
exit
fi

if [ ! -d ${third_dir} ]; then
madir -p ${third_dir}
fi
prepare_install_dependecy
}

function prepare_seccomponent(){
seccomponent="seccomponent-1.1.5-release"
prepareYum x86_64 intrusive-modification
yum makecache
yumdownloader --downloadonly --enablerepo=intrusive-modification --destdir ${imagesHome}/ ${seccomponent}
}

function prepare_third_software(){
prepare_nginx_rpm
prepare_seccomponent

cp -f ${workdir}/init_third.sh ${third_dir}/
cp -f ${imagesHome}/${make}.x86_64.rpm  ${third_dir}/
cp -f ${imagesHome}/${compat_openssl10}.x86_64.rpm  ${third_dir}/
cp -f ${imagesHome}/${NGINX_RPM}  ${third_dir}/
cp -f ${imagesHome}/${seccomponent}.x86_64.rpm  ${third_dir}/

cd ${third_dir}/..
tar -cvzf ${third_dir_name}.tar.gz ${third_dir_name}
cp -f ${third_dir_name} ${imagesHome}
echo "[INFO] prepare nginx rpm install package success: $(date)"
}

function main(){
workdir=$(
cd $(dirname $0)
pwd
)
export_env

# 打包nginx 配置文件和docker entrypoint脚本
tar_files

#准备nginx rpm 安装包，加密套件
prepare_third_software

#制作nginx镜像
cd ${imagesHome}
docker build -t nginx:${service_version}
}
main