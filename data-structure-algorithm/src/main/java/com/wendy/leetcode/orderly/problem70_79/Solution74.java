package com.wendy.leetcode.orderly.problem70_79;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/9/12 9:19
 * @Version 1.0
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length - 1; i++) {
            if (target >= matrix[i][0] && target < matrix[i + 1][0]) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
                return false;
            }
        }

        // 从最后一行查找
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[matrix.length - 1][i] == target) {
                return true;
            }
        }
        return false;
    }
}
