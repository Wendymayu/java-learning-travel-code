package com.wendy.basic.multi_thread;
/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/10/8 22:01
 * @Version 1.0
 */
public class InteruptTest {
    public static void main(String[] args) {
        try {
            MyThread2 thread = new MyThread2();
            thread.start();
            Thread.sleep(20);//modify 2000 to 20
            thread.interrupt();//请求中断MyThread线程
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            if (this.interrupted()) {
                System.out.println("should be stopped and exit");
                break;
            }
            System.out.println("i=" + (i + 1));
        }
        //尽管线程被中断,但并没有结束运行。这行代码还是会被执行
        System.out.println("this line is also executed. thread does not stopped");
    }
}

class MyThread3 extends Thread {
    @Override
    public void run() {
        super.run();
        try{
            for (int i = 0; i < 500000; i++) {
                if (this.interrupted()) {
                    System.out.println("should be stopped and exit");
                    throw new InterruptedException();
                }
                System.out.println("i=" + (i + 1));
            }
            //这行语句不会被执行!!!
            System.out.println("this line cannot be executed. cause thread throws exception");
        }catch(InterruptedException e){
            System.out.println("catch interrupted exception");
            e.printStackTrace();
        }
    }
}