package com.wendy.basic.io;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/12/8 20:21
 * @Version 1.0
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(s);
        }
    }
}
