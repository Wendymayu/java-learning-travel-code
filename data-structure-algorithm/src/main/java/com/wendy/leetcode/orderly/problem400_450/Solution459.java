package com.wendy.leetcode.orderly.problem400_450;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/12/14 21:43
 * @Version 1.0
 */
public class Solution459 {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(repeatedSubstringPattern(s));
    }

    /**
     * 暴力从头取子串，如果子串是重复字符串，则其长度必能被字符串长度整除
     * @param s
     * @return
     */
    static public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        for (int i = 1; i <= length / 2; i++) {
            String sub = s.substring(0, i);
            if (length % sub.length() != 0 && length / sub.length() <= 1) {
                return false;
            } else if (length % sub.length() != 0) {
                continue;
            } else {
                int num = length / sub.length();
                for (int j = 0; j < num; j++) {
                    boolean same = sub.equals(s.substring(j * sub.length(), (j + 1) * sub.length()));
                    if (same) {
                        if (j == num - 1) {
                            return true;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return false;
    }
}
