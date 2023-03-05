package com.wendy.sword_for_offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/12 10:26
 * @Version 1.0
 */
public class Solution3 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}
