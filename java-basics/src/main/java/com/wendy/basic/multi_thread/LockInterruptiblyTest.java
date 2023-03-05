package com.wendy.basic.multi_thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/10/8 23:43
 * @Version 1.0
 */
public class LockInterruptiblyTest {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockInterruptiblyTest lockInterruptiblyTest = new LockInterruptiblyTest();
        Thread thread0 = new Thread(() -> {
            try {
                lockInterruptiblyTest.insert(Thread.currentThread());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中断");
            }
        });

        Thread thread1 = new Thread(() -> {
            try {
                lockInterruptiblyTest.insert(Thread.currentThread());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中断");
            }
        });
        thread0.start();
        thread1.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.interrupt();
    }

    public void insert(Thread thread) throws InterruptedException {
        System.out.println(thread.getName() + "想拥有锁");
        lock.lockInterruptibly();
        System.out.println(thread.getName() + "得到了锁");
        Thread.sleep(2000);
        lock.unlock();
        System.out.println(thread.getName() + "释放了锁");
    }
}

