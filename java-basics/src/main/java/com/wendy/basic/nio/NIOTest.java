package com.wendy.basic.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/6/14 23:27
 * @Version 1.0
 */
public class NIOTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile(new File("data\\nio-data.txt"), "rw");
        FileChannel inChannel = aFile.getChannel();
        //create buffer with capacity of 48 bytes
        ByteBuffer buf = ByteBuffer.allocate(48);
        //read into buffer
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            buf.flip();  //make buffer ready for read
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get()); // read 1 byte at a time
            }
            buf.clear(); //make buffer ready for writing
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
