package com.wendy.leetcode.orderly.problem400_450;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/1 21:35
 * @Version 1.0
 */
public class Solution401 {
    public static void main(String[] args) {
        int a = 0b1111;
        int b = 0b11;
        int res = a & b;
        System.out.println(Integer.toBinaryString(res));
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                int bitNum = Integer.bitCount(i) + Integer.bitCount(j);
                if (bitNum == turnedOn) {
                    String min = j < 10 ? ("0" + j) : j + "";
                    res.add(i + ":" + min);
                }
            }
        }
        return res;
    }
}
