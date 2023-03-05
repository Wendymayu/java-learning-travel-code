package com.wendy.basic.io;

import java.io.*;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/9/26 21:36
 * @Version 1.0
 */
public class DataInputStreamTest {
    public static void main(String[] args) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("dataIn.txt"));
        dataOutputStream.writeUTF("dandan");
        dataOutputStream.writeDouble(1.68);
        dataOutputStream.writeInt(100);

        //FileOutputStream fileOutputStream = new FileOutputStream("dataIn.txt");
        //fileOutputStream.write("wendy");//不能写字符串
        //fileOutputStream.write(1000);

        System.out.println("测试FileInputStream----------------------");
        FileInputStream in = new FileInputStream("dataIn.txt");
        while(in.read()!=-1){
            System.out.println(in.read());
        }

        System.out.println("测试DataInputStream-------------------------");
        try( DataInputStream dataInputStream = new DataInputStream(new FileInputStream("dataIn.txt"));){
            while(true){
                System.out.println(dataInputStream.readUTF());
                System.out.println(dataInputStream.readDouble());
                System.out.println(dataInputStream.readInt());
            }
        }catch (EOFException e){
            System.out.println("All data were read");
        }
    }
}
