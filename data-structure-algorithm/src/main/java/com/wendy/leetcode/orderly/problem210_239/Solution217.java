package com.wendy.leetcode.orderly.problem210_239;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution217
 * @Description TODO
 * @Author wendyma
 * @Date 2021/7/18 15:07
 * @Version 1.0
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>1){
                return true;
            }
        }
        return false;
    }
}
