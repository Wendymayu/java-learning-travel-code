package com.wendy.leetcode.orderly.problem210_239;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 * @Author wendyma
 * @Date 2021/7/18 22:35
 * @Version 1.0
 */
public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer item : map.keySet()) {
            if(map.get(item)*3>nums.length){
                result.add(item);
            }
        }
        return result;
    }
}
