package com.wendy.basic.multi_thread.synchronized_prac;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/7/23 12:39
 * @Version 1.0
 */
public class ThreadUnsafeTest {
    static final int THREAD_NUMBER = 2;
    static final int LOOP_NUMBER = 200;
    public static void main(String[] args) {
        ThreadUnsafe test = new ThreadUnsafe();
        for (int i = 0; i < THREAD_NUMBER; i++) {
            new Thread(() -> {
                test.method1(LOOP_NUMBER);
            }, "Thread" + i).start();
        }
    }
}
