package com.wendy.leetcode.orderly.problem120_139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否
 * 可以被空格拆分为一个或多个在字典中出现的单词。拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * @Author wendyma
 * @Date 2021/8/7 17:03
 * @Version 1.0
 */
public class Solution139 {
    public static void main(String[] args) {
        //String s = "leetcode";
        //String s = "applepenapple";
        String s = "catsandog";
        //String s = "ab";
        List<String> wordDict = new ArrayList<>();
        // wordDict.add("leet");
        //wordDict.add("code");
        // String[] dict = {"apple", "pen"};
        String[] dict = {"cats", "dog", "sand", "and", "cat"};
        //String[] dict = {"a","b"};
        for (int i = 0; i < dict.length; i++) {
            wordDict.add(dict[i]);
        }
        System.out.println(wordBreak(s, wordDict));
    }

    //下面的方法aaaaaaa与aaaa aaa这种情况无法通过。看似这题需要用回溯，实际动态规划
    static public boolean wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {

            if (wordDict.contains(s.substring(0, i + 1))) {
                list.add(s.substring(0, i + 1));
                s = s.substring(i + 1);
                i = -1;
            }else if(i == s.length() - 1){
                return false;
            }
        }
        return true;
    }

    //appbugpeep  判断包含g的单词bug，其前面的字符串自否可以被分割，如果可以，则g处就可以。
    //g后的字母需遍历判断
    static public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
