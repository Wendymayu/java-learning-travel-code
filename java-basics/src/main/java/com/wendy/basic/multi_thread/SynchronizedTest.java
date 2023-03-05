package com.wendy.basic.multi_thread;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/10/7 20:11
 * @Version 1.0
 */
public class SynchronizedTest {

    public static void main(String[] args) throws InterruptedException {
        // 两个线程的锁对象都是 test 实例
        MyThread1 test = new MyThread1();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        //System.out.println(i);
    }

}

class MyThread1 implements Runnable {
    //使用静态变量定义共享资源
    static int i = 0;

    /**
     * synchronized 修饰实例方法
     */
    public synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            increase();
        }
        System.out.println(i);
    }

    public synchronized void method() {
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }
}
