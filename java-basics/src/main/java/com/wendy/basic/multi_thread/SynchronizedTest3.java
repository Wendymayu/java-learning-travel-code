package com.wendy.basic.multi_thread;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/10/7 20:51
 * @Version 1.0
 */
public class SynchronizedTest3 implements Runnable {
    private static Integer myLock = 128;
    static int i = 0;

    @Override
    public void run() {
        synchronized (SynchronizedTest3.class) {
            for (int j = 0; j < 10000; j++) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new SynchronizedTest3());
        Thread t2 = new Thread(new SynchronizedTest3());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
