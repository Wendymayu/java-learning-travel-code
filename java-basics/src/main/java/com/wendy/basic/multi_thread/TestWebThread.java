/*
package com.wendy.basic.multi_thread;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

*/
/**
 * @ClassName TestWebThread
 * @Description TODO
 * @Author wendyma
 * @Date 2021/7/11 21:18
 * @Version 1.0
 *//*

@Controller
@RequestMapping("/webThread")
public class TestWebThread {
    int i = 100;

    @GetMapping("/run")
    @ResponseBody
    public String testRun(){
        new Thread() {
            public void run() {
                i--;
                System.out.println("线程: "+Thread.currentThread().getName());
            }
        }.start();
        return "剩余"+i;
    }

    @GetMapping("/run1")
    @ResponseBody
    public String testRun1(){
        i--;
        //从下面这个输出可以看到spring默认开启10个线程
        System.out.println("线程: "+Thread.currentThread().getName());
        return "剩余"+i;
    }
}
*/
