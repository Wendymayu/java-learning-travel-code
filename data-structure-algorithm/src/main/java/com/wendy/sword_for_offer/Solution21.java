package com.wendy.sword_for_offer;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/12 13:25
 * @Version 1.0
 */
public class Solution21 {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while (nums[left] % 2 != 0 && left < right) {
                left++;
            }
            while (nums[right] % 2 == 0 && left < right) {
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            // 交换后指针需要移动
            left++;
            right--;
        }
        return nums;
    }
}
