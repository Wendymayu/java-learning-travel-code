package com.wendy.leetcode.orderly.problem451_500;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/16 14:13
 * @Version 1.0
 */
public class Solution482 {
    public static void main(String[] args) {
        String s = "2-4A0r7-4k";
        int k = 3;
        System.out.println(licenseKeyFormatting(s, k));
    }

    static public String licenseKeyFormatting(String s, int k) {
        String[] strings = s.split("-");
        String newString = Arrays.stream(strings).map(String::toUpperCase).collect(Collectors.joining());
        StringBuilder sb = new StringBuilder();
        int start = newString.length() % k;
        if (start != 0) {
            sb.append(newString.substring(0, start));
        }

        for (int i = start; i < newString.length(); i += k) {
            if (i != 0) {
                sb.append("-");
            }
            sb.append(newString.substring(i, i + k));
        }
        return sb.toString();
    }
}
