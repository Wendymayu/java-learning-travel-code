package com.wendy.leetcode.orderly.problem210_239;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/21 22:37
 * @Version 1.0
 */
public class Solution213 {
    public static void main(String[] args) {
        //int[] nums = {2,3,2};
        //int[] nums = {1, 2, 3, 1};
        //int[] nums = {1, 2, 3};
       // int[] nums = {4, 1, 2, 7, 5, 3, 1};
        int[] nums = {2,2,4,3,2,5};  // 我的答案无法考虑到偷下标 1  3  5的情况，除非我将数据翻转再算一遍，
        System.out.println(rob(nums));
    }

    static public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[len];
        boolean[] isContainOne = new boolean[len];
        dp[0] = nums[0];
        isContainOne[0] = true;
        dp[1] = Math.max(nums[0], nums[1]);
        if (nums[0] > nums[1]) {
            isContainOne[1] = true;
        } else {
            isContainOne[1] = false;
        }

        for (int i = 2; i < len; i++) {
            if (dp[i - 2] + nums[i] > dp[i - 1]) {
                dp[i] = dp[i - 2] + nums[i];
                isContainOne[i] = isContainOne[i - 2];
            } else {
                dp[i] = dp[i - 1];
                isContainOne[i] = isContainOne[i - 1];
            }
        }
        int res = 0;
        if (dp[len - 2] > dp[len - 1]) {
            res = dp[len - 2];
        } else {
            if (isContainOne[len - 1]) {
                res = Math.max(dp[len - 3], dp[len - 2]);
                res = Math.max(res, dp[len - 1] - nums[0]);
            } else {
                res = dp[len - 1];
            }
        }
        return res;
    }
}
