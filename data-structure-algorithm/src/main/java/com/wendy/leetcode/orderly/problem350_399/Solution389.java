package com.wendy.leetcode.orderly.problem350_399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Solution389
 * @Description TODO
 * @Author wendyma
 * @Date 2021/7/18 13:56
 * @Version 1.0
 */
public class Solution389 {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference4(s,t));
    }

    //hash级数
    static public char findTheDifference(String s, String t) {
        Map<Character,Integer> maps = new HashMap<>();
        Map<Character,Integer> mapt = new HashMap<>();

        for(int i=0;i<s.length();i++){
            maps.put(s.charAt(i),maps.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<t.length();i++){
            mapt.put(t.charAt(i),mapt.getOrDefault(t.charAt(i),0)+1);
        }
        for(Character c:mapt.keySet()){
            // Map.Entry<Character,Integer> entry = mapt.get
            if(maps.get(c)!=mapt.get(c)){
                return c;
            }
        }
        return ' ';
    }

    //优化，使用t获得list，使用s删除其中的元素。
    static public char findTheDifference2(String s, String t) {
        List<Character> listt = new ArrayList<>();
        for(int i=0;i<t.length();i++){
            listt.add(t.charAt(i));
        }
        for(int i=0;i<s.length();i++){
            listt.remove((Character)s.charAt(i));//不能以位置删除，而要以对象删除。注意删除时char字符会自动转化为数字
        }

        return listt.get(0);
    }

    //用数组比用List更香
    public char findTheDifference3(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }
    //还可以统计每个字符串中字符的asiic码和。两者和的插值就是要返回的字符

    //位运算。如果将两个字符串拼接成一个字符串，则问题转换成求字符串中出现奇数次的字符
    //0位或数字得数字本身，数字位或自己得0
   static public char findTheDifference4(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }


}
