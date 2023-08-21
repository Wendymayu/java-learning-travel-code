package com.wendy.leetcode.orderly.problem501_700;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/16 11:44
 * @Version 1.0
 */
public class Solution557 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    static public String reverseWords(String s) {
        int left = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                reverse(chars, left, i - 1);
                left = i + 1;
            }
        }
        reverse(chars, left, s.length() - 1);
        return String.valueOf(chars);
    }

    static public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

}
