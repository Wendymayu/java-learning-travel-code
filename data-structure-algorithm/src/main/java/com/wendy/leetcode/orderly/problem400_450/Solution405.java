package com.wendy.leetcode.orderly.problem400_450;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/2 19:03
 * @Version 1.0
 */
public class Solution405 {
    public static void main(String[] args) {
        int num = 16;
        System.out.println(toHex(num));
    }

    public static String toHex(int num) {
        if (num == 0) return "0";
        List<String> list = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f");
        String res = "";
        int remain = 0;
        while (num > 0) {
            remain = num % 16;
            num = num / 16;
            res = list.get(remain) + res;
        }
        return res;
    }
}
