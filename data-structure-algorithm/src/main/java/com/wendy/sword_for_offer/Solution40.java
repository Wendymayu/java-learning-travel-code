package com.wendy.sword_for_offer;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/12 11:24
 * @Version 1.0
 */
public class Solution40 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int[] res = getLeastNumbers(arr, 2);
        ArrayUtils.printElement(res);
    }

    static public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }
}
