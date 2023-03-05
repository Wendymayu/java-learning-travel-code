package com.wendy.leetcode.orderly.problem120_139;

import com.wendy.utils.ListUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/12/11 16:23
 * @Version 1.0
 */
public class Solution131_2 {
    public static void main(String[] args) {
        // String s = "aab";
        String s = "cbbbcc";
        List<List<String>> lists = partition(s);
        for (List list : lists) {
            ListUtils.printList(list);
        }
    }

    static int[][] f;

    static public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        f = new int[len][len];
        Deque<String> stack = new ArrayDeque<>();
        dfs(s, 0, s.length(), stack, res);
        return res;
    }

    static private void dfs(String s, int index, int len, Deque<String> stack, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<>(stack));
        } else {
            for (int i = index; i < len; i++) {
                if (checkPalindrome(s, index, i) == 1) {
                    stack.addLast(s.substring(index, i + 1));
                    dfs(s, i + 1, len, stack, res);
                    stack.removeLast();
                }
            }
        }
    }

    static private int checkPalindrome(String s, int i, int j) {
        if (f[i][j] != 0) {
            return f[i][j];
        }
        if (i >= j) {
            f[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = checkPalindrome(s, i + 1, j - 1);
        } else {
            f[i][j] = -1;
        }
        return f[i][j];
    }
}
