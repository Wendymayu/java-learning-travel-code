package com.wendy.leetcode.orderly.problem80_89;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/29 22:48
 * @Version 1.0
 */
public class Solution84 {
    /**
     * 使用双指针的难点在于移动哪个指针
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int res = 0;
        while (left <= right) {
            int[] area = getArea(heights, left, right);
            res = Math.max(res, area[0]);
            if (getArea(heights, left, area[1] - 1)[0] < getArea(heights, area[1]+1, right)[0]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    private int[] getArea(int[] heights, int start, int end) {
        if (end < start) {
            return new int[]{0, start};
        }
        int min = heights[start];
        int minIndex = start;
        for (int i = start; i <= end; i++) {
            if (heights[i] < min) {
                min = heights[i];
                minIndex = i;
            }
        }
        int[] res = new int[2];
        res[0] = (end - start + 1) * min;
        res[1] = minIndex;
        return res;
    }
}
