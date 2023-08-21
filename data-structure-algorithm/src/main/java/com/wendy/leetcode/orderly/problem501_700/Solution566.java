package com.wendy.leetcode.orderly.problem501_700;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/16 15:56
 * @Version 1.0
 */
public class Solution566 {
    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 4;
        int c = 1;
        System.out.println(matrixReshape(mat, r, c));
    }

    static public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int order = i * c + j;
                res[i][j] = mat[order / n][order % n];
            }
        }
        return res;
    }
}
