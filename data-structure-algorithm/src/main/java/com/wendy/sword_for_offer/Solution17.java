package com.wendy.sword_for_offer;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/12 11:34
 * @Version 1.0
 */
public class Solution17 {
    public int[] printNumbers(int n) {
        int max = 1;
        for (int i = 0; i < n; i++) {
            max *= 10;
        }
        max -= 1;
        // 用自带的库算幂更好
        // int max = (int)Math.pow(10, n) - 1;
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
