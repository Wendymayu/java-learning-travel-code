package com.wendy.leetcode.orderly.problem160_179;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/19 20:44
 * @Version 1.0
 */
public class Solution162 {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[len - 1] > nums[len - 2]) return len - 1;
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }
}
