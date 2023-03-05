package com.wendy.basic.multi_thread.create_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/9/7 21:59
 * @Version 1.0
 */
public class FutureTaskDemo {
    public static void main(String[] args) {
        // 创建任务对象
        FutureTask<Integer> task3 = new FutureTask<>(() -> {
            return 100;
        });
        // 参数1 是任务对象; 参数2 是线程名字，推荐
        new Thread(task3, "t3").start();

       // 主线程阻塞，同步等待 task 执行完毕的结果
        try {
            Integer result = task3.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("执行异常");
        }

        Callable<String> callable = ()->{
            Thread.sleep(100);
            return "task result";
        };
    }
}
