package com.wendy.sword_for_offer;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/12 15:47
 * @Version 1.0
 */
public class Solution42 {
    public int maxSubArray(int[] nums) {
        int leng = nums.length;
        int[] dp = new int[leng];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < leng; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
