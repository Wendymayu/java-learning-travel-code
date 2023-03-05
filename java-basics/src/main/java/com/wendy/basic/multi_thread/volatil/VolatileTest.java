package com.wendy.basic.multi_thread.volatil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/10/10 11:57
 * @Version 1.0
 */
public class VolatileTest {
    static boolean inited = false;
    static String s;

    public static void main(String[] args) {
        TestVolatile testVolatile = new TestVolatile();
        testVolatile.testVolatile();
    }

}

class TestVolatile {
   volatile static boolean inited;
    Student student;

    public void testVolatile() {
        new Thread() {
            public void run() {
                student = new Student("wendy", 20);
                inited = true;
                System.out.println("线程1运行");
            }
        }.start();
        new Thread() {
            public void run() {
                if (inited) {
                    System.out.println("字符串已初始化:" + student);
                    System.out.println("线程2后运行");
                } else {
                    System.out.println("字符串未初始化:" + student);
                    System.out.println("线程2先运行");
                }
            }
        }.start();
    }

    public void testVolatile2() {
        new Thread() {
            public void run() {
                student = new Student("wendy", 20);   //语句1
                inited = true;             //语句2
                int sum = 0;
                for(int i=0;i<100000;i++){
                    sum++;
                }
                System.out.println("线程1运行");
            }
        }.start();
        new Thread() {
            public void run() {
                while (!inited) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(student.getName());
            }
        }.start();
    }
}

@AllArgsConstructor
@Data
@ToString
class Student {
    private String name;

    private Integer age;
}
