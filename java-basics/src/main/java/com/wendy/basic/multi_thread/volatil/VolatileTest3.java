package com.wendy.basic.multi_thread.volatil;

/**
 * @Description 验证volatile解决可见性问题，代码来源于网络
 * @Author wendyma
 * @Date 2021/12/12 22:15
 * @Version 1.0
 */

public class VolatileTest3 {
    public boolean isShutdown;

    public boolean getShutdown () {
        return isShutdown;
    }

    public void shutdown () {
        isShutdown = true;
    }

    class ReaderThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("开始循环");
                while (!isShutdown) {

                }
                System.out.println("结束循环");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class WatchThread extends Thread {
        @Override
        public void run() {
            shutdown();
        }
    }

    public static void main(String[] args){
        try {
            VolatileTest3 volatileTest3 = new VolatileTest3();
            volatileTest3.new ReaderThread().start();
            //让主线程睡眠一秒，确保另一个线程调用shutdown方法时死循环已经开始
            Thread.sleep(1000);

            volatileTest3.new WatchThread().start();
            //此刻的睡眠是为了确保shutdown方法对isShutdown变量的修改已经同步到主内存
            Thread.sleep(1000);
            //打印isShutdown的值
            System.out.println("getShutdown:" + volatileTest3.getShutdown());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

