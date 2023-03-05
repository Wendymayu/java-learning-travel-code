package com.wendy.basic.io;

import java.io.*;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/9/27 7:40
 * @Version 1.0
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("objectIn.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        try (
                ObjectOutputStream objectOutputStream =
                        new ObjectOutputStream(new FileOutputStream("objectIn.txt"))
        ) {
            objectOutputStream.writeUTF("john");
            objectOutputStream.writeDouble(85.5);
            //不序列化对象，无法写入文件
            objectOutputStream.writeObject(new Student("wendy", 25));
        }

        try (
                ObjectInputStream objectInputStream =
                        new ObjectInputStream(new FileInputStream("objectIn.txt"))
        ) {
            String name = objectInputStream.readUTF();
            double age = objectInputStream.readDouble();
            Student student = (Student) (objectInputStream.readObject());//必须抛出ClassNotFoundException
            System.out.println(name + " " + age + " " + student);
        }
    }
}
