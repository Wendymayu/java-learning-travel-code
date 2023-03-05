package com.wendy.sword_for_offer;

import utils.ArrayUtils;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/13 0:10
 * @Version 1.0
 */
public class Solution29 {
    public static void main(String[] args) {
       // int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = new int[0][0];
        ArrayUtils.printElement(spiralOrder(matrix));
    }

    static public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new int[0];
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] directs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] used = new int[matrix.length][matrix[0].length];
        int[] res = new int[height * width];
        int r = 0;
        int c = 0;
        int nextR = 0;
        int nextC = 0;
        int direction = 0;
        for (int i = 0; i < height * width; i++) {
            res[i] = matrix[r][c];
            used[r][c] = 1;
            nextR = r + directs[direction][0];
            nextC = c + directs[direction][1];
            if (nextR >= height || nextR < 0 || nextC >= width || nextC < 0 || used[nextR][nextC] == 1) {
                direction = (direction + 1) % 4;
            }
            r += directs[direction][0];
            c += directs[direction][1];
        }
        return res;
    }
}
