package com.wendy.leetcode.orderly.problem501_700;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/16 17:12
 * @Version 1.0
 */
public class Solution594 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
//        int[] nums = {1, 1, 1, 1};
        System.out.println(findLHS(nums));
    }

    static public int findLHS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int left = 0;
        int mid = 0;
        int right = 0;
        int res = 0;
        while (right < nums.length) {
            if (nums[right] > nums[left] + 1) {
                if (nums[right] > nums[mid] + 1) {
                    mid = right;
                    left = mid;
                } else {
                    left = mid;
                    mid = right;
                }
            } else if (nums[right] == nums[left] + 1) {
                if (nums[mid] != nums[right]) {
                    mid = right;
                }
            }
            if (nums[right] == nums[left] + 1) {
                res = Math.max(res, right - left + 1);
            }
            right++;
        }
        return res;
    }
}
