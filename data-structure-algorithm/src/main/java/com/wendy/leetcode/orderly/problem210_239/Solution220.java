package com.wendy.leetcode.orderly.problem210_239;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/24 22:43
 * @Version 1.0
 */
public class Solution220 {
    public static void main(String[] args) {
        Solution220 solution220 = new Solution220();
        int[] nums = {1, 2, 3, 1};
        int indexDiff = 3;
        int valueDiff = 0;
        /*int[] nums = {1,5,9,1,5,9};
        int indexDiff = 2;
        int valueDiff = 3;*/
        System.out.println(solution220.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > indexDiff) {
                list.remove(0);
            }
            if (isDuplicate(list, nums[i], valueDiff)) {
                return true;
            } else {
                list.add(nums[i]);
            }
        }
        return false;
    }

    private boolean isDuplicate(List<Integer> list, int num, int valueDiff) {
        for (int i = 0; i < list.size(); i++) {
            if (Math.abs(list.get(i) - num) <= valueDiff) {
                return true;
            }
        }
        return false;
    }
}
