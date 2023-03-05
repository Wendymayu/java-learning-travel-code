package com.wendy.jmock;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/12/21 21:16
 * @Version 1.0
 */
public class FileExport {
    boolean export() {
        FileReader fileReader = new FileReader();
        String content = fileReader.readFromServer();
        System.out.println("The content is: " + content);
        return true;
    }
}
