package com.wendy.basic.io;

import java.io.File;
import java.io.IOException;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/9/25 20:58
 * @Version 1.0
 */
public class FileTest {
    public static void main(String[] args) {
        // 创建文件夹
        File direc = new File("D:"+File.separator+"ma");
        direc.mkdir();
        File file = new File("tmp.txt"); // 创建文件对象，注意只是文件的抽象封装，不是磁盘上的文件
        if(!file.exists()){ // 文件不存在则新建文件
            try{
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        System.out.println(file.getAbsolutePath());
        String fileName = "test.txt";
        System.out.println("File.separator:" + File.separator);
        File testFile = new File("D:" + File.separator + "filepath" + File.separator + "test" + File.separator + fileName);
        File fileParent = testFile.getParentFile();//返回的是File类型,可以调用exsit()等方法
        String fileParentPath = testFile.getParent();//返回的是String类型
        System.out.println("fileParent:" + fileParent);
        System.out.println("fileParentPath:" + fileParentPath);
        if (!fileParent.exists()) {
            fileParent.mkdirs();// 能创建多级目录
        }
        if (!testFile.exists()){
            try {
                testFile.createNewFile();//有路径才能创建文件
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        System.out.println(testFile);

        String path = testFile.getPath();
        String absolutePath = testFile.getAbsolutePath();//得到文件/文件夹的绝对路径
        String getFileName = testFile.getName();//得到文件/文件夹的名字
        System.out.println("path:"+path);
        System.out.println("absolutePath:"+absolutePath);
    }
}
