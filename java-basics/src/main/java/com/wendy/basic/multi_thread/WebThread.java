package com.wendy.basic.multi_thread;

/**
 * @ClassName WebThread
 * @Description TODO
 * @Author wendyma
 * @Date 2021/7/11 21:09
 * @Version 1.0
 */
public class WebThread extends Thread {
    private Integer num;

    public WebThread(Integer num) {
        this.num = num;
    }

    public void run() {
        num--;
        System.out.println(Thread.currentThread().getName() + num);
    }
}
