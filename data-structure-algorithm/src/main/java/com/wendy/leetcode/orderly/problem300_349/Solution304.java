package com.wendy.leetcode.orderly.problem300_349;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/27 10:31
 * @Version 1.0
 */
public class Solution304 {
    public static void main(String[] args) {
        Solution304 solution304 = new Solution304();

    }
}

class NumMatrix {
    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                res += matrix[i][j];
            }
        }
        return res;
    }
}