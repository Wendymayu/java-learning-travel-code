package com.wendy.leetcode.orderly.problem40_69;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/13 10:02
 * @Version 1.0
 */
public class Solution59 {
    public static void main(String[] args) {

    }
    static public int[][] generateMatrix(int n) {
        int[][] directs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] used = new int[n][n];
        int[][] matrix = new int[n][n];
        int r = 0;
        int c = 0;
        int nextR = 0;
        int nextC = 0;
        int direction = 0;
        for (int i = 0; i < n * n; i++) {
            matrix[r][c] = i + 1;
            used[r][c] = 1;
            nextR = r + directs[direction][0];
            nextC = c + directs[direction][1];
            if (nextR >= n || nextR < 0 || nextC >= n || nextC < 0 || used[nextR][nextC] == 1) {
                direction = (direction + 1) % 4;
            }
            r += directs[direction][0];
            c += directs[direction][1];
        }
        return matrix;
    }
}
