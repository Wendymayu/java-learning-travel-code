package com.wendy.basic.object_oriented.inner_class;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/9/18 21:55
 * @Version 1.0
 */
public class OuterClass {
    Integer age = 30;
    static String name = "土皮";
    public void display(){
        System.out.println("OuterClass...");
    }

    /*推荐使用getxxx()来获取成员内部类，尤其是该内部类的构造函数无参数时 */
    public InnerClass getInnerClass(){
        return new InnerClass();
    }

    public class InnerClass{
        public OuterClass getOuterClass(){
            return OuterClass.this;
        }

        public void display(){
            System.out.println("inner_class...");
        }
    }

    public static class StaticInnerClass{

        /*
         * 静态内部类只能访问外围类的静态成员变量和方法
         * 不能访问外围类的非静态成员变量和方法
         */
        public void display(){
            System.out.println(name);
            System.out.println("staticInnerClass...");
        }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();
        innerClass.getOuterClass().display();
        InnerClass innerClass1 = outerClass.getInnerClass();
    }
}
