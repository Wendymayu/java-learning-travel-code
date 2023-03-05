package com.wendy.leetcode.orderly.problem300_349;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/27 13:42
 * @Version 1.0
 */
public class Solution307 {
    public static void main(String[] args) {
        int[] nums = {7, 2, 7, 2, 0};
        NumArray2 numArray2 = new NumArray2(nums);
        numArray2.update(4, 6);
        numArray2.update(0, 2);
        numArray2.update(0, 9);
        System.out.println(numArray2.sumRange(4, 4));
        numArray2.update(3, 8);
        System.out.println(numArray2.sumRange(0, 4));
        numArray2.update(4, 1);
        System.out.println(numArray2.sumRange(0, 3));
        System.out.println(numArray2.sumRange(0, 4));
        numArray2.update(0, 4);
    }
}

class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public void update(int index, int val) {
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += nums[i];
        }
        return res;
    }
}

class NumArray2 {
    private int[] sum;
    private int[] nums;

    public NumArray2(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public void update(int index, int val) {
        for (int i = index; i < nums.length; i++) {
            sum[i + 1] = sum[i + 1] + val - nums[index];
        }
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}