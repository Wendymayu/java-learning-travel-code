package com.wendy.leetcode.orderly.problem180_199;

import com.wendy.utils.ArrayUtils;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/20 14:13
 * @Version 1.0
 */
public class Solution189 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        ArrayUtils.printElement(nums);
    }

    static public void rotate(int[] nums, int k) {
        int leng = nums.length;
        k %= leng;
        if (k == 0) return;
        int[] temp = new int[k];

        for (int i = 0; i < k; i++) {
            temp[k - 1 - i] = nums[leng - 1 - i];
        }
        for (int i = leng - 1; i > k - 1; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}
