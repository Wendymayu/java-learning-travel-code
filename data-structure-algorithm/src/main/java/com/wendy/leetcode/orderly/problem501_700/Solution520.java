package com.wendy.leetcode.orderly.problem501_700;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/16 9:48
 * @Version 1.0
 */
public class Solution520 {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        int lowerNum = 0;
        int upperNum = 0;
        for (int i = 0; i < word.length(); i++) {
            if ('a' <= word.charAt(i) && word.charAt(i) <= 'z') {
                lowerNum++;
            } else {
                upperNum++;
            }
        }
        // 仅首字母大写
        if (upperNum == 1 && 'A' <= word.charAt(0) && word.charAt(0) <= 'Z') {
            return true;
        }

        // 所有字母都大写或小写
        if (upperNum == word.length() || lowerNum == word.length()) {
            return true;
        }
        return false;
    }
}
