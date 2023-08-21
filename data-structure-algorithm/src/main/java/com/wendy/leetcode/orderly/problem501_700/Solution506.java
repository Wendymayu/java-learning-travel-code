package com.wendy.leetcode.orderly.problem501_700;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/3 23:02
 * @Version 1.0
 */
public class Solution506 {
    public static void main(String[] args) {
        int[] score = {5, 4, 3, 2, 1};
        String[] relativeRanks = findRelativeRanks(score);
        for (int i = 0; i < score.length; i++) {
            System.out.println(relativeRanks[i]);
        }
    }

    public static String[] findRelativeRanks(int[] score) {
        Integer[] scoreCopy = new Integer[score.length];
        for (int i = 0; i < score.length; i++) {
            scoreCopy[i] = score[i];
        }

        Arrays.sort(scoreCopy, (a, b) -> b - a);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < scoreCopy.length; i++) {
            map.put(scoreCopy[i], i + 1);
        }
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            String rank = map.get(score[i]) + "";
            if (rank.equals("1")) {
                rank = "Gold Medal";
            } else if (rank.equals("2")) {
                rank = "Silver Medal";
            } else if (rank.equals("3")) {
                rank = "Bronze Medal";
            }
            result[i] = rank;
        }
        return result;
    }
}
