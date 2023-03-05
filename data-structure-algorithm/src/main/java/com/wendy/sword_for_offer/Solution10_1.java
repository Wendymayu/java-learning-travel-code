package com.wendy.sword_for_offer;

/**
 * @Author wendyma
 * @Date 2022/11/12 11:06
 * @Version 1.0
 */
public class Solution10_1 {
    public static void main(String[] args) {
        System.out.println(fib(3));
    }

    static public int fib(int n) {
        int a = 0;
        int b = 1;
        if (n == 0) {
            return a;
        } else if (n == 1) {
            return b;
        }
        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = (b + a) % 1000000007;
            a = temp;
        }
        return b;
    }
}
