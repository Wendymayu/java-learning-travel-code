package com.wendy.leetcode.orderly.problem40_69;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/8/29 21:55
 * @Version 1.0
 */
public class Solution55 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
   static public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        int[] canJump = new int[nums.length];
        if(nums[0]>0){
            canJump[0]=1;
        }else{
            return false;
        }
        for(int i=0;i<nums.length-1;i++){
            if(canJump[i]==1){
                for(int j=1;j<=nums[i];j++){
                    if(i+j>=nums.length-1){
                        return true;
                    }
                    canJump[i+j] = 1;
                }
            }
        }
        return false;
    }
}
