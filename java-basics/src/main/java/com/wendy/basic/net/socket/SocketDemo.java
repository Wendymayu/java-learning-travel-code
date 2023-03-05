package com.wendy.basic.net.socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/12/31 16:14
 * @Version 1.0
 */
public class SocketDemo {
    public static void main(String[] args) throws Exception {
        SocketDemo socketDemo = new SocketDemo();
        //   socketDemo.readSocket();

        // socketDemo.connectLocalServer();

        //  socketDemo.writeSocket();

        socketDemo.getDaytime();
    }

    public void readSocket() {
        Socket socket = null;
        try {
            socket = new Socket("time.nist.gov", 13);
            socket.setSoTimeout(5000);
            InputStream inputStream = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.US_ASCII);
            int c;
            while ((c = reader.read()) != -1) {
                time.append((char) c);
            }
            System.out.println(time);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                    System.out.println("close socket success");
                } catch (IOException e) {
                    System.out.println("close socket error");
                }
            }
        }
    }

    public void writeSocket() throws Exception {
        String SERVER = "dict.org";
        int PORT = 2628;
        Socket socket = null;
        try {
            socket = new Socket(SERVER, PORT);
            socket.setSoTimeout(20000);

            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            writer = new BufferedWriter(writer);

            StringBuilder time = new StringBuilder();
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.US_ASCII));

            String[] input = {"apple"};
            for (String word : input) {
                define(word, writer, reader);
            }
            writer.write("quit");
            writer.flush();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                    System.out.println("close socket success");
                } catch (IOException e) {
                    System.out.println("close socket error");
                }
            }
        }

    }

    private void define(String word, Writer writer, BufferedReader reader) throws Exception {
        writer.write("DEFINE eng-zh " + word + "\r\n");
        writer.flush();

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            if (line.startsWith("250 ")) {
                return;
            } else if (line.startsWith("552 ")) {
                System.out.println("No definition found for " + word);
            } else if (line.matches("\\d\\d\\d .*")) {
                continue;
            } else if (line.trim().equals(".")) {
                continue;
            } else {
                System.out.println(line);
            }
        }
    }

    public void connectLocalServer() {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 8080);
            socket.setSoTimeout(5000);
            InputStream inputStream = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.US_ASCII);
            int c;
            while ((c = reader.read()) != -1) {
                time.append((char) c);
            }
            System.out.println(time);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                    System.out.println("close socket success");
                } catch (IOException e) {
                    System.out.println("close socket error");
                }
            }
        }
    }

    private void setSocketProperties() throws Exception {
        Socket socket = new Socket();

        socket.setTcpNoDelay(true);

        socket.setSoLinger(true, 2000);

        socket.setSoTimeout(1000);

        socket.setReceiveBufferSize(1024);

        socket.setSendBufferSize(1024);

        socket.setKeepAlive(true);

        socket.setReuseAddress(false);
    }

    public void getDaytime() {
        try {
            Socket socket = new Socket("localhost", 8081);
            socket.setSoTimeout(5000);
            InputStream inputStream = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.US_ASCII);
            int c;
            while ((c = reader.read()) != -1) {
                time.append((char) c);
            }
            System.out.println(time);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
