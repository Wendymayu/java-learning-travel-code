package com.wendy.basic.multi_thread.synchronized_prac;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/7/23 12:36
 * @Version 1.0
 */
public class ThreadUnsafe {
    ArrayList<String> list = new ArrayList<>();

    public void method1(int loopNumber) {
        for (int i = 0; i < loopNumber; i++) {
            // 临界区, 会产生竞态条件
            method2();
            method3();
        }
    }

    private void method2() {
        list.add("1");
        System.out.println("add");
    }
    private void method3() {
        list.remove(0);
        System.out.println("remove");
    }
}
