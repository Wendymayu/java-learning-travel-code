package com.wendy.leetcode.orderly.problem180_199;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/9 23:20
 * @Version 1.0
 */
public class Solution198 {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    /**
     * [2,1,1,2]  我的解法未考虑这种情况
     * @param nums
     * @return
     */
   static public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        max = sum;
        sum = 0;
        for (int i = 1; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum > max ? sum : max;
    }

    /**
     * 官方解答  动态规划
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
