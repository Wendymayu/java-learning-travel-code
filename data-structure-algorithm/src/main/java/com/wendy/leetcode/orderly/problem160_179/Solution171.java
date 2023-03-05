package com.wendy.leetcode.orderly.problem160_179;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/7/23 23:15
 * @Version 1.0
 */
public class Solution171 {
    public static void main(String[] args) {
        //String s = "A";
       // String s = "AB";
        String s = "ZY";
        System.out.println(titleToNumber(s));
    }
    public static int titleToNumber(String columnTitle) {
        int number = 0;
        int radix = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int n = columnTitle.charAt(i) - 64;
            number += n * radix;
            radix *= 26;
        }
        return number;
    }
}

class Test{

    public void test(){

    }
}
