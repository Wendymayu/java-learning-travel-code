package com.wendy.leetcode.orderly.problem400_450;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/10 23:15
 * @Version 1.0
 */
public class Solution438 {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> res = findAnagrams(s, p);
        for (int i : res) {
            System.out.println(i);
        }
    }

    /**
     * 滑动窗口
     */
    static public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }

        int[] arrayP = new int[26];
        for (int i = 0; i < p.length(); i++) {
            arrayP[p.charAt(i) - 'a'] += 1;
        }

        int[] arrayS = new int[26];
        for (int i = 0; i < p.length(); i++) {
            arrayS[s.charAt(i) - 'a'] += 1;
        }
        if (Arrays.equals(arrayS, arrayP)) {
            res.add(0);
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            arrayS[s.charAt(i) - 'a'] -= 1;
            arrayS[s.charAt(i + p.length()) - 'a'] += 1;

            if (Arrays.equals(arrayS, arrayP)) {
                res.add(i + 1);
            }
        }
        return res;
    }

    /**
     * 我的暴力解法
     */
/*    static public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (isXRWord(s.substring(i, i + p.length()), p)) {
                res.add(i);
            }
        }
        return res;
    }

    static private boolean isXRWord(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);

        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars2);

        if (String.valueOf(chars1).equals(String.valueOf(chars2))) {
            return true;
        }
        return false;
    }*/

}
