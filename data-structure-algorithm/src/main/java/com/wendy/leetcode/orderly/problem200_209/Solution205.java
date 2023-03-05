package com.wendy.leetcode.orderly.problem200_209;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，
 * 相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 我的解答; 这是一个一一映射，每个字母只能映射到唯一对应的一个字母，反之也是。
 * 因此可以用map得到映射关系，用此关系将s->s1，如果无误，则s1=t. 正向成立。（相同字符只能映射到同一个字符上）
 * 用反关系map, t->t1. 如果无误，则t1=s. 反向成立。（不同字符不能映射到同一个字符上）
 * @Author wendyma
 * @Date 2021/7/23 23:32
 * @Version 1.0
 */
public class Solution205 {
    public static void main(String[] args) {
        //String s = "egg";
        //String t = "add";

        //String s = "egg";
        //String t = "adr";

        String s = "badc";
        String t = "baba";

        System.out.println(isIsomorphic(s, t));
    }

    static public boolean isIsomorphic(String s, String t) {
        String s1 = mapString(s, t);
        String t1 = mapString(t, s);
        return s1.equals(t) && t1.equals(s);
    }

    static public String mapString(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), t.charAt(i));
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            sb.append(map.get(s.charAt(i)));
        }
        return sb.toString();
    }
}
