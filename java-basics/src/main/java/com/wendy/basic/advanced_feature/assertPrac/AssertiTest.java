package com.wendy.basic.advanced_feature.assertPrac;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/9/12 21:17
 * @Version 1.0
 */
public class AssertiTest {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        //assert b!=0;
        assert b!=0:"除数只能为1";
        System.out.println(a/b);
    }
}
