package com.wendy.basic.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/9/27 23:45
 * @Version 1.0
 */
public class ZipInputStreamTest {
    static String zipFileName = "D:/router.zip";

    public static void main(String[] args) throws IOException {

        zipMultiFile();
        System.out.println("读取压缩文件----------------------------------------");
        //readZipForZipInputStream(zipFileName);
    }

    static public void zipOneFile() throws IOException {
        File file = new File("D:" + File.separator + "dan.txt");
        File zipFile = new File("D:" + File.separator + "router.zip");
        InputStream input = new FileInputStream(file);
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        zipOut.putNextEntry(new ZipEntry(file.getName()));
        // 设置注释
        zipOut.setComment("hello");
        int temp = 0;
        while ((temp = input.read()) != -1) {
            zipOut.write(temp);
        }
        input.close();
        zipOut.close();
    }

    static public void zipMultiFile() throws IOException {
        // 要被压缩的文件夹
        File file = new File("d:" + File.separator + "router");
        File zipFile = new File("d:" + File.separator + "router.zip");
        InputStream input = null;
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        zipOut.setComment("hello");
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; ++i) {
                System.out.println(files[0]);
                input = new FileInputStream(files[i]);
                zipOut.putNextEntry(new ZipEntry(file.getName() + File.separator + files[i].getName()));

                // 把文件内容写入到ZipEntry中
                int temp = 0;
                while ((temp = input.read()) != -1) {
                    zipOut.write(temp);
                }
                input.close();
            }
        }
        zipOut.close();
    }

    static public void unzipOneFile() throws IOException{
        File file = new File("d:" + File.separator + "hello.zip");
        File outFile = new File("d:" + File.separator + "unZipFile.txt");
        ZipFile zipFile = new ZipFile(file);
        ZipEntry entry = zipFile.getEntry("hello.txt");//hello.txt 为压缩包中文件的名称
        InputStream input = zipFile.getInputStream(entry);
        OutputStream output = new FileOutputStream(outFile);
        int temp = 0;
        while ((temp = input.read()) != -1) {
            output.write(temp);
        }
        input.close();
        output.close();
    }

    static public void unzipMultiFile() throws IOException {
        File file = new File("d:" + File.separator + "zipFile.zip");
        File outFile = null;
        ZipFile zipFile = new ZipFile(file);
        ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));
        ZipEntry entry = null;
        InputStream input = null;
        OutputStream output = null;
        while ((entry = zipInput.getNextEntry()) != null) {
            //entry.getName()获得压缩包内的文件及文件路径（aaaa/bb.txt）
            System.out.println("解压缩" + entry.getName() + "文件");
            outFile = new File("d:" + File.separator + entry.getName());
            if (!outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdir();
            }
            if (!outFile.exists()) {
                outFile.createNewFile();
            }
            input = zipFile.getInputStream(entry);
            output = new FileOutputStream(outFile);
            int temp = 0;
            while ((temp = input.read()) != -1) {
                output.write(temp);
            }
            input.close();
            output.close();
        }
    }
    static public void readZipForZipInputStream(String zipFileName) {
        ZipInputStream zip;
        try {
            zip = new ZipInputStream(new FileInputStream(new File(zipFileName)));
            ZipEntry zipEntry = null;
            while ((zipEntry = zip.getNextEntry()) != null) {
                String fileName_zip = zipEntry.getName();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] byte_s = new byte[1024];
                int num = -1;
                while ((num = zip.read(byte_s, 0, byte_s.length)) > -1) {
                    byteArrayOutputStream.write(byte_s, 0, num);
                }

                byte[] byte_s_ = byteArrayOutputStream.toByteArray();
                String fileNeirong = new String(byte_s, "UTF-8");
                System.out.println(fileNeirong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
