package com.wendy.leetcode.orderly.problem451_500;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/16 14:03
 * @Version 1.0
 */
public class Solution476 {
    public static void main(String[] args) {
        int num = 1;
        System.out.println(findComplement(num));
    }

    static public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                chars[i] = '1';
            } else {
                chars[i] = '0';
            }
        }
        return Integer.parseInt(String.valueOf(chars), 2);
    }
}
