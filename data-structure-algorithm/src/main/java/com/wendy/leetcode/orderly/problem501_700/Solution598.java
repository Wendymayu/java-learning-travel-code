package com.wendy.leetcode.orderly.problem501_700;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/16 20:59
 * @Version 1.0
 */
public class Solution598 {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] ops = {{2, 2}, {3, 3}};
        System.out.println(maxCount(m, n, ops));
    }

    static public int maxCount(int m, int n, int[][] ops) {
        int x = m;
        int y = n;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i][0] != 0 && ops[i][1] != 0) {
                x = Math.min(x, ops[i][0]);
                y = Math.min(y, ops[i][1]);
            }
        }
        return x * y;
    }
}
