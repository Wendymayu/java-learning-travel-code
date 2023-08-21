package com.wendy.leetcode.orderly.problem501_700;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/16 11:25
 * @Version 1.0
 */
public class Solution551 {
    public boolean checkRecord(String s) {
        int absentNum = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absentNum++;
            }
            if (absentNum >= 2) {
                return false;
            }
        }
        return !s.contains("LLL");
    }
}
