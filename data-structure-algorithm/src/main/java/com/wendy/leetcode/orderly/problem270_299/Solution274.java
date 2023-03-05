package com.wendy.leetcode.orderly.problem270_299;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/20 16:32
 * @Version 1.0
 */
public class Solution274 {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println(hIndex(citations));
    }
    static public int hIndex(int[] citations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < citations.length; i++) {
            map.put(citations[i], map.getOrDefault(citations[i], 0) + 1);
        }

        for (int i = 1000; i > 0; i--) {
            int hIndex = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() >= i) {
                    hIndex += entry.getValue();
                }
            }
            if (hIndex >= i) {
                return i;
            }
        }
        return 0;
    }
}
