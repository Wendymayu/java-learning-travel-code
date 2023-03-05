package com.wendy.leetcode.orderly.problem400_450;

import java.util.Arrays;

/**
 * @ClassName Solution414
 * @Description 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * @Author wendyma
 * @Date 2021/7/18 17:19
 * @Version 1.0
 */
public class Solution414 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1};
        System.out.println(thirdMax(nums));

    }
    //如何给数组降序排序？
    //我最初想用hashSet去重，但是如何给set排序？
    //TreeSet<Integer> set=new TreeSet(); treeSet可以自动给元素排序去重
   static public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if(len<3){
            return nums[len-1];
        }
        int result = nums[len-1];
        int index = 1;
        for(int i=len-2;i>=0;i--){
            if(nums[i]<result){
                result = nums[i];
                index++;
            }
            if(index==3){
                return result;
            }
        }
        return nums[len-1];
    }
}
