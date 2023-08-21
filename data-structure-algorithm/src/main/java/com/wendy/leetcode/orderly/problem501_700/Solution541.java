package com.wendy.leetcode.orderly.problem501_700;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/16 10:59
 * @Version 1.0
 */
public class Solution541 {
    public static void main(String[] args) {
        String s = "abcd";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }

    static public String reverseStr(String s, int k) {
        StringBuffer res = new StringBuffer();
        int reverseNum = s.length() / (2 * k) + 1;
        for (int i = 0; i < reverseNum; i++) {
            int right = Math.min(s.length(), (i + 1) * 2 * k);
            res.append(reverse(s.substring(i * 2 * k, right), k));
        }
        return res.toString();
    }

    static private String reverse(String s, int k) {
        if (s.length() == 0) {
            return "";
        } else if (s.length() <= k) {
            return new StringBuffer(s).reverse().toString();
        } else {
            return new StringBuffer(s.substring(0, k)).reverse().toString() + s.substring(k);
        }
    }

}
