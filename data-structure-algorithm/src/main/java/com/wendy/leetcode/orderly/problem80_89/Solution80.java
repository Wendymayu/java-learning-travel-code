package com.wendy.leetcode.orderly.problem80_89;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/13 10:55
 * @Version 1.0
 */
public class Solution80 {
    public static void main(String[] args) {
        //int[] nums = {1, 1, 1, 2, 2, 3};
        //int[] nums = {0,0,1,1,1,1,2,3,3};
        //int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] nums = {1, 1, 1, 2, 3};

        System.out.println(removeDuplicates(nums));
    }

    static public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0;
        int right = 1;
        int count = 1;
        while (right < nums.length) {
            // 两个指针的数值不同
            if (nums[right] != nums[left]) {
                left++;
                nums[left] = nums[right];
                right++;
                count = 1;
            } else if (nums[right] == nums[left] && count < 2) { // 两个只针的数值相同

                left++;
                if (nums[left] < nums[left - 1]) {
                    nums[left] = nums[right];
                }
                right++;
                count++;
            } else if (nums[right] == nums[left] && count >= 2) {
                right++;
            }
        }
        return left + 1;
    }
}
