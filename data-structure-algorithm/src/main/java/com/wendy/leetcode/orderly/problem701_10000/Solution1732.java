package com.wendy.leetcode.orderly.problem701_10000;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/19 20:28
 * @Version 1.0
 */
public class Solution1732 {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int height = 0;
        for (int i = 0; i < gain.length; i++) {
            height += gain[i];
            if (height > max) {
                max = height;
            }
        }
        return max;
    }
}
