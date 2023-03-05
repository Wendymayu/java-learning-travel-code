package com.wendy.basic.process_oriented.constants;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/12/19 8:54
 * @Version 1.0
 */
public class IntegerTest {
    public static void main(String[] args) {
        int int1 = 20;
        int int2 = 20;

        Integer integer1 = new Integer(20);
        Integer integer2 = new Integer(20);

        Integer a1 = 127;
        Integer a2 = 127;
        Integer a3 = Integer.valueOf(127);
        Integer a4 = new Integer(127);

        Integer a = 128;
        Integer b = 128;

        System.out.println("int1 == int2 -> " + (int1 == int2));
        System.out.println("int1 == integer1 -> " + (int1 == integer1));
        System.out.println("integer1 == integer2 -> " + (integer1 == integer2));
        System.out.println("a1 == a2 -> " + (a1 == a2));
        System.out.println("a1 == a3 -> " + (a1 == a3));
        System.out.println("a1 == a4 -> " + (a1 == a4));
        System.out.println("a == b -> " + (a == b));
    }
}
