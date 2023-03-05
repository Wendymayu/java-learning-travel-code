package com.wendy.basic.multi_thread.happens_before;

import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/2/5 20:01
 * @Version 1.0
 */
public class HappensBeforeTest1 {
    static int x;

    static int y;

    static Object m = new Object();

    volatile static int volatile_x;

    public static void main(String[] args) {
        // case1();

        // case2();

        // case6();

        aa();
    }

    private static void case1() {
        new Thread(() -> {
            synchronized (m) {
                x = 10;
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (m) {
                System.out.println(x);
            }
        }, "t2").start();
    }

    private static void case2() {
        new Thread(() -> {
            volatile_x = 10;
        }, "t1").start();

        new Thread(() -> {
            System.out.println(volatile_x);
        }, "t2").start();
    }

    private static void case3() {
        x = 10;

        new Thread(() -> {
            System.out.println(x);
        }, "t2").start();
    }

    private static void case4() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            x = 10;
        }, "t1");

        t1.start();
        t1.join();
        System.out.println(x);
    }

    private static void case5() {
        Thread t2 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(x);
                    break;
                }
            }
        }, "t2");
        t2.start();

        new Thread(() -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
            x = 10;
            t2.interrupt();
        }, "t1").start();

        while (!t2.isInterrupted()) {
            Thread.yield();
        }
        System.out.println(x);
    }

    private static void case6() {
        new Thread(() -> {
            y = 10;
            volatile_x = 20;
        }, "t1").start();

        new Thread(() -> {
            System.out.println(volatile_x);
            System.out.println(y);
        }, "t2").start();
    }

    private static void aa(){
        String[] list = {"sf", "fasdf"};
        Object[] objects = list;

        List l = Arrays.asList("sf", "fasdf");

        System.out.println(l.toArray());
        System.out.println(l.toArray(new Object[0]));
    }


}
