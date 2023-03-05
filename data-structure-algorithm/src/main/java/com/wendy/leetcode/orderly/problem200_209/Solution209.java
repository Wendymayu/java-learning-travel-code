package com.wendy.leetcode.orderly.problem200_209;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/9/11 12:43
 * @Version 1.0
 */
public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            right++;
            while (sum >= target) {
                min = Math.min(min, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
