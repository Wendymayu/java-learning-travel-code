package com.wendy.leetcode.orderly.problem400_450;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/12/14 20:26
 * @Version 1.0
 */
public class Solution434 {
    public static void main(String[] args) {
        String s = "   ";
        System.out.println(countSegments(s));
    }

    static public int countSegments(String s) {
        return Arrays.stream(s.trim().split(" "))
                .filter(item -> item.length() > 0)
                .collect(Collectors.toList()).size();
    }
}
