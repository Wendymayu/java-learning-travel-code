package com.wendy.leetcode.orderly.problem400_450;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/12/14 20:39
 * @Version 1.0
 */
public class Solution409 {
    public static void main(String[] args) {
        // String s = "abccccdd";
        String s = "bb";
        System.out.println(longestPalindrome(s));
    }

    static public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        boolean flag = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                res += entry.getValue();
            } else {
                flag = true;
                res += entry.getValue() - 1;
            }
        }
        // 回文串中间字母个数可以为奇数
        return flag ? res + 1 : res;
    }
}
