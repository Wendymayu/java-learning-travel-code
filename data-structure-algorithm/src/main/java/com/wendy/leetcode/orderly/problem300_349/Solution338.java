package com.wendy.leetcode.orderly.problem300_349;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/8/26 23:18
 * @Version 1.0
 */
public class Solution338 {
    public static void main(String[] args) {
        int[] res = countBits(5);
        for (int item : res) {
            System.out.println(item);
        }
    }

    static public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            int num = 0;
            int tmp = i;
            while (tmp != 0) {
                if ((tmp & 1) == 1) {
                    num++;
                }
                tmp = tmp >> 1;
            }
            res[i] = num;
        }
        return res;
    }
}
