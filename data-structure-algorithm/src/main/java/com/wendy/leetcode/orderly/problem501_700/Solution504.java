package com.wendy.leetcode.orderly.problem501_700;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/16 10:21
 * @Version 1.0
 */
public class Solution504 {
    public static void main(String[] args) {
        int num = 100;
        System.out.println(convertToBase7(num));
    }

    static public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean positive = num > 0;
        int absNum = Math.abs(num);
        String res = "";
        while (absNum > 0) {
            res = absNum % 7 + res;
            absNum = absNum / 7;
        }
        return positive ? res : "-" + res;
    }
}
