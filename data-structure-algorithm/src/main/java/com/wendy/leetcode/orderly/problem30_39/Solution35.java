package com.wendy.leetcode.orderly.problem30_39;

public class Solution35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 3;
        System.out.println(searchInsert(nums,target));
    }
    public static int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target) return i+1;
            if(target<nums[i]) return i+1;
        }
        return nums.length;
    }
}
