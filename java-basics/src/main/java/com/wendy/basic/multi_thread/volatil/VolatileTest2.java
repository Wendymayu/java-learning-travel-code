package com.wendy.basic.multi_thread.volatil;

/**
 * @Description 验证volatile与原子性的关系
 * @Author wendyma
 * @Date 2021/12/12 16:42
 * @Version 1.0
 */
public class VolatileTest2 implements Runnable{
    //使用静态变量定义共享资源
    static volatile int i =0;
    @Override
    public void run(){
        for (int j =0 ; j<10000;j++){
            i++;
        }
        System.out.println(i);
    }
    public static void main(String[] args) throws InterruptedException {
        VolatileTest2 test = new VolatileTest2();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
    }
}
