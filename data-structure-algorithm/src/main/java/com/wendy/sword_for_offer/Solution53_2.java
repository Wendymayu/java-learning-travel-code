package com.wendy.sword_for_offer;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/12 16:10
 * @Version 1.0
 */
public class Solution53_2 {
    public int missingNumber(int[] nums) {
        int[] res = new int[nums.length];
        for (int num : nums) {
            res[num] = 1;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0) {
                return i;
            }
        }
        return 0;
    }
}
