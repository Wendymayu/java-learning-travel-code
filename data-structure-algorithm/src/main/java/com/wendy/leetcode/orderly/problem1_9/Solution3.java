package com.wendy.leetcode.orderly.problem1_9;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/9/11 11:27
 * @Version 1.0
 */
public class Solution3 {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    static public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int left = 0;
        int right = 0;
        int res = 0;
        // 窗口中的字符串substring(left, right + 1)
        while (right + 1 < s.length()) {
            int index = s.substring(left, right + 1).indexOf(s.charAt(right + 1) + "");
            if (index == -1) {
                right++;
            } else {
                right++;
                left = left + index + 1;
            }

            if (right - left + 1 > res) {
                res = right - left + 1;
            }
        }
        return res;
    }
}
