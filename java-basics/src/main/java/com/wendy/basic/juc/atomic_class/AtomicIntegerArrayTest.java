package com.wendy.basic.juc.atomic_class;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/1/28 21:26
 * @Version 1.0
 */
public class AtomicIntegerArrayTest {
    public static void main(String[] args) throws Exception {
        AtomicIntegerArray array = new AtomicIntegerArray(new int[]{45, 23, 13, 47, 12, 42});
        for (int i = 0; i < array.length(); i++) {
            final int j = i;
            new Thread(() -> {
                // array.compareAndSet(j, 13, 31);
                array.getAndAdd(j, 2);
                // array.decrementAndGet(j);
                //    array.getAndSet(j, array.get(j) - 1);
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(array);
    }
}
