package com.wendy.basic.net.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/12/31 17:09
 * @Version 1.0
 */
public class ServerSocketDemo {
    public static void main(String[] args) throws Exception {
        ServerSocketDemo demo = new ServerSocketDemo();

        //demo.sendHello();

        demo.sendDaytime();
    }

    public void sendHello() throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            try (Socket connection = server.accept()) {
                System.out.println("There is a client connected");
                Writer writer = new OutputStreamWriter(connection.getOutputStream());
                writer.write("hello world");
                writer.flush();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void sendDaytime() throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(50);
        try (ServerSocket server = new ServerSocket(8081)) {
            while (true) {
                try (Socket connection = server.accept()) {
                    System.out.println("There is a client connected");
                    //generateDaytime(connection);
                    pool.submit(() ->
                            generateDaytime(connection)
                    );
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (IOException e) {
            System.out.println("Couldn't start server");
        }
    }

    private void generateDaytime(Socket connection) {
        OutputStreamWriter out;
        try {
            out = new OutputStreamWriter(connection.getOutputStream());
            Date now = new Date();
            out.write(now.toString() + "\r\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (IOException e) {
                System.out.println("close connection error");
            }
        }
    }
}
