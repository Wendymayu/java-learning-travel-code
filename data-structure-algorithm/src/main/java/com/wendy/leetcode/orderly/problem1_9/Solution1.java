package com.wendy.leetcode.orderly.problem1_9;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution1
 * @Description TODO
 * @Author wendyma
 * @Date 2021/7/14 20:11
 * @Version 1.0
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        for(int i:twoSum(nums,9)){
            System.out.println(i);
        }
    }
   static public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        int[] result = new int[2];
        int res = nums[0];
        map.put(res,0);
        for(int i=1;i<nums.length;i++){
            res = target-nums[i];
            if(map.containsKey(res)){
                result[0] = i;
                result[1] = map.get(res);
                break;
            }else{
                map.put(nums[i],i);
            }
        }
        return result;
    }
}
