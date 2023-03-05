package com.wendy.basic.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/12/8 21:47
 * @Version 1.0
 */
public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("tmp.txt");
        FileOutputStream out = new FileOutputStream("output.txt");
        byte[] content = new byte[1024];
        while(in.read(content)!=-1){
            out.write(content);
        }
    }
}
