package com.wendy.leetcode.orderly.problem80_89;

/**
 * @ClassName Solution88
 * @Description 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，
 * 这样它就有足够的空间保存来自 nums2 的元素。
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * @Author wendyma
 * @Date 2021/7/17 21:07
 * @Version 1.0
 */
public class Solution88 {
    public static void main(String[] args) {
        /*int[] nums1 = {2, 0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;*/
        int[] nums1 = {0,0,0,0,0};
        int m = 0;
        int[] nums2 = {1,2,3,4,5};
        int n = 5;
        merge(nums1, m, nums2, n);
        for (int i : nums1) {
            System.out.println(i);
        }

    }

    //直接插入排序，不要考虑数据元素是否为0
    static public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            int j;
            for (j = m + i - 1; j >= 0 && nums2[i] < nums1[j]; j--) {
                    nums1[j + 1] = nums1[j];
            }
            nums1[j + 1] = nums2[i];
        }
    }
}
