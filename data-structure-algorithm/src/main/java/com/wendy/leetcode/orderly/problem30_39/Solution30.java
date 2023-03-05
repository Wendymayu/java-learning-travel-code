package com.wendy.leetcode.orderly.problem30_39;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Solution30
 * @Description 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以
 * 由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 *思路：判断s中每一个连续长度为words.length * words[0].length()的子串是否是数组串联的子串

 * @Author wendyma
 * @Date 2021/7/14 22:20
 * @Version 1.0
 */
public class Solution30 {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        System.out.println(findSubstring2(s,words));
    }
   static public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int len = words.length * words[0].length();
        for (int i = 0; i < s.length() - len+1; i++) {
            List<String> list1 = new ArrayList<>();
            for (int j = i; j < len+i; j += words[0].length()) {
                list1.add(s.substring(j,j+words[0].length()));
            }
            //下面的代码比较List和数组元素是否相等
            for(int j=0;j<words.length;j++){
                if(!list1.contains(words[j])){
                    break;
                }else{
                    list1.remove(words[j]);
                }
                if(j==words.length-1){
                    result.add(i);
                }
            }
        }
        return result;
    }

    //用map优化我的代码
    static public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int len = words.length * words[0].length();

        Map<String,Integer> map = new HashMap();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        for (int i = 0; i < s.length() - len+1; i++) {
            Map<String,Integer> temp_map = new HashMap();
            for (int j = i; j < len+i; j += words[0].length()) {
                String temp = s.substring(j,j+words[0].length());
                temp_map.put(temp,temp_map.getOrDefault(temp,0)+1);
            }
            //下面的代码比较List和数组元素是否相等
            if(map.equals(temp_map))
                result.add(i);
        }
        return result;
    }

    static public List<Integer> findSubstring3(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < one_word; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>();
            while (right + one_word <= s.length()) {
                String w = s.substring(right, right + one_word);
                tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                right += one_word;
                count++;
                //一次以一个单词长度为单位滑，但凡窗口中有单词不在word中，窗口直接移到当前单词右方
                while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                    String t_w = s.substring(left, left + one_word);
                    count--;
                    tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                    left += one_word;
                }
                if (count == word_num) res.add(left);

            }
        }

        return res;
    }
}
