package com.wendy.basic.io;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/11/28 20:20
 * @Version 1.0
 */
public class TestCharArrayWriter {
    public static void main(String[] args) throws IOException {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        charArrayWriter.write("保护环境");
        char[] c = charArrayWriter.toCharArray();

        CharArrayReader car = new CharArrayReader(c);
        int i;
        while((i=car.read())!=-1){
            System.out.println((char)i);
        }
    }
}
