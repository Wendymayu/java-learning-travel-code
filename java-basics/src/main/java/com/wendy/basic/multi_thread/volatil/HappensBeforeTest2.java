package com.wendy.basic.multi_thread.volatil;

/**
 * @Description 该程序可以验证 volatile 要解决的可见性问题
 * @Author wendyma
 * @Date 2021/12/12 20:34
 * @Version 1.0
 */
public class HappensBeforeTest2 {
    private Foo sharedFoo;
    private boolean inited;

    public void publisher() {
        sharedFoo = new Foo(42);
        inited = true;
        System.out.println("publish执行: inited is " + inited);
    }

    public void consumer() {
        System.out.println("开始循环");
        while (!inited) {

        }
        System.out.println("结束循环");
        System.out.println(sharedFoo.nr);
    }

    public static void main(String[] args) {
        try {
            HappensBeforeTest2 test = new HappensBeforeTest2();
            new Thread() {
                public void run() {
                    test.consumer();
                }
            }.start();
            Thread.sleep(1000);
            new Thread() {
                public void run() {
                    test.publisher();
                }
            }.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
