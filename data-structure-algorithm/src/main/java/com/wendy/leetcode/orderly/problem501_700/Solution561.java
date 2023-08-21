package com.wendy.leetcode.orderly.problem501_700;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/16 13:54
 * @Version 1.0
 */
public class Solution561 {
    // 每次都选第2大的
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }
}
