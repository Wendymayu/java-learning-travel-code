package com.wendy.basic.process_oriented.string;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/10/11 23:49
 * @Version 1.0
 */
public class StringTest {
    public static void main(String[] args) {
        String s = "wendyMa";
        System.out.println(s.hashCode());
        StringTest stringTest = new StringTest();
        stringTest.change(s);
        System.out.println(s);
        System.out.println(s.hashCode());
    }
    //ClassLoader

    public void change(String s){
        System.out.println(s);
        System.out.println(s.hashCode());
        s = "hhh";
        System.out.println(s);
        System.out.println(s.hashCode());
    }
}
