package com.wendy.basic.multi_thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/10/7 22:22
 * @Version 1.0
 */
public class LockTest {
    private Lock lock = new ReentrantLock();

    //需要参与同步的方法
    private void method(Thread thread) {
        lock.lock();
        try {
            System.out.println("线程名" + thread.getName() + "获得了锁");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("线程名" + thread.getName() + "释放了锁");
            lock.unlock();
        }
    }

    private void method2(Thread thread) {
        if (lock.tryLock()) {
            try {
                System.out.println("线程名" + thread.getName() + "获得了锁");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("线程名" + thread.getName() + "释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println("线程名" + Thread.currentThread().getName() + "有人占着锁，我就不要啦");
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        //线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.method(Thread.currentThread());
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            lockTest.method(Thread.currentThread());
        }, "t2");

        Thread t3 = new Thread(() -> {
            lockTest.method2(Thread.currentThread());
        }, "t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
