package com.wendy.leetcode.orderly.problem701_10000;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/23 16:40
 * @Version 1.0
 */
public class Solution918 {
    public static void main(String[] args) {
//        int[] nums = {1, -2, 3, -2};
//        int[] nums = {5, -3, 5};
        int[] nums = {-2};
//        int[] nums = {3, -1, 2, -1};
        System.out.println(maxSubarraySumCircular(nums));
    }

    static public int maxSubarraySumCircular(int[] nums) {
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            int index = 0;
            int[] dp = new int[n];
            dp[index] = nums[j];
            j = (j + 1) % n;
            while (j != i) {
                dp[index + 1] = (dp[index] > 0) ? (dp[index] + nums[j]) : nums[j];
                j = (j + 1) % n;
                index++;
            }
            dp[n - 1] = dp[n - 2] > 0 ? dp[n - 2] + nums[i] : nums[i];
            res = Math.max(dp[n - 1], res);
        }
        return res;
    }


}
