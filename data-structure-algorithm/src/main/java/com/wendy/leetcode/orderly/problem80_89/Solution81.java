package com.wendy.leetcode.orderly.problem80_89;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/13 14:05
 * @Version 1.0
 */
public class Solution81 {
    public static void main(String[] args) {
/*        int[] nums = {1, 0, 1, 1, 1};
        int target = 0;*/
        int[] nums = {2, 5, 6, 0, 0,1, 2};
        int target = 3;
        System.out.println(search(nums, target));
    }

    static public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) { // 不知道哪一部分是增
                start++;
                end--;
            } else if (nums[start] <= nums[mid]) {  //前半部分有序,注意此处用小于等于
                //target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // 后半部分有序
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return false;
    }

    static public boolean search2(int[] nums, int target) {
        for (int i : nums) {
            if (i == target) {
                return true;
            }
        }
        return false;
    }

}
