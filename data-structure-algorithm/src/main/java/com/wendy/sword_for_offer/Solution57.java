package com.wendy.sword_for_offer;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/12 16:29
 * @Version 1.0
 */
public class Solution57 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[]{0, 0};
    }
}
