package com.wendy.leetcode.orderly.problem240_269;

import java.util.Arrays;

/**
 * @ClassName Solution268
 * @Description 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * @Author wendyma
 * @Date 2021/7/18 15:40
 * @Version 1.0
 */
public class Solution268 {
    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(missingNumber(nums));
    }
    //我的解法：如果缺失边界数字，判断是哪个边界。
    //数字排好序，如果缺失中间数字，必然有一位元素比它前面的元素大2
    static public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            if(nums[i]+1<nums[i+1]){
                return nums[i]+1;
            }
        }
        return nums[0]==0?nums[n-1]+1:0;
    }

    //异或法：绝了绝了
    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

}
