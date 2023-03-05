package com.wendy.sword_for_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/12 16:02
 * @Version 1.0
 */
public class Solution53_1 {
    public int search(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.containsKey(target) ? map.get(target) : 0;
    }
}
