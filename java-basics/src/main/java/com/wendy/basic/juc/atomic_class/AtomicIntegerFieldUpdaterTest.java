package com.wendy.basic.juc.atomic_class;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/1/28 22:01
 * @Version 1.0
 */
public class AtomicIntegerFieldUpdaterTest {
    public static void main(String[] args) {
        Student stu = new Student(10);

        //创建AtomicIntegerFieldUpdater对象
        AtomicIntegerFieldUpdater<Student> studentAtomicIntegerFieldUpdater =
                AtomicIntegerFieldUpdater.newUpdater(Student.class, "age");

        System.out.println(studentAtomicIntegerFieldUpdater.getAndIncrement(stu));
        System.out.println(stu.age);
    }
}

class Student {
    //因为是用反射实现的这里必须要使用public修饰
    public volatile int age;

    public Student(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
