package com.wendy.leetcode.orderly.problem240_269;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution242
 * @Description 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * @Author wendyma
 * @Date 2021/7/18 15:21
 * @Version 1.0
 */
public class Solution242 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram2(s,t));
    }

    //方法一：hash计数
    static public boolean isAnagram(String s, String t) {
        Map<Character,Integer> maps = new HashMap<>();
        Map<Character,Integer> mapt = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            maps.put(s.charAt(i), maps.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i=0;i<t.length();i++) {
            mapt.put(t.charAt(i), mapt.getOrDefault(t.charAt(i), 0) + 1);
        }

        return maps.equals(mapt);
    }

    //方法二：对字符串排序，比较每位字符是否相同。这种方式比hash快多了
    static public boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length())
            return false;
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();
        Arrays.sort(s_array);
        Arrays.sort(t_array);
        for(int i=0;i<s.length();i++){
            if(s_array[i]!=t_array[i]){
                return false;
            }
        }
        //直接比较数组更好
        //Arrays.equals(s_array,t_array);
        return true;
    }
}
