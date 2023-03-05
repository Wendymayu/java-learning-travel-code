package com.wendy.leetcode.orderly.problem1_9;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/12/11 21:01
 * @Version 1.0
 */
public class Solution5 {
    public static void main(String[] args) {
        // String s = "babad";
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    static public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        int max = 0;
        String res = s.substring(0, 1);
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
                if (f[i][j] && j - i > max) {
                    res = s.substring(i, j + 1);
                    max = j - i;
                }
            }
        }
        return res;
    }
}
