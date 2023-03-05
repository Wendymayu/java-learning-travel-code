package com.wendy.basic.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/9/26 23:30
 * @Version 1.0
 */
public class BufferInputStreamTest {
    public static void main(String[] args) {
        try {
            File file = new File("buffered.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileInputStream fis = new FileInputStream("buffered.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            String content = "";
            //自己定义一个缓冲区
            byte[] buffer = new byte[1024];
            int flag = 0;
            while ((flag = bis.read(buffer)) != -1) {
                content += new String(buffer, 0, flag);
            }
            System.out.println(content);
            //关闭的时候只需要关闭最外层的流就行了
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
