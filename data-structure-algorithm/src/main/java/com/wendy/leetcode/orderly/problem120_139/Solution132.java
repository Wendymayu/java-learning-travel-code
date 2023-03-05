package com.wendy.leetcode.orderly.problem120_139;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/12/11 16:51
 * @Version 1.0
 */
public class Solution132 {
    public static void main(String[] args) {
        Solution132Code solution132Code = new Solution132Code();
        String s = "aab";
        System.out.println(solution132Code.minCut(s));
    }
}

class Solution132Code {
    int[][] f;

    public int minCut(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            res.add(s.charAt(i) + "");
        }
        if (len == 1) {
            return 0;
        }
        f = new int[len][len];
        Deque<String> stack = new ArrayDeque<>();
        dfs(s, 0, s.length(), stack, res);
        return res.size() - 1;
    }

    private void dfs(String s, int index, int len, Deque<String> stack, List<String> res) {
        if (index == len) {
            if (stack.size() < res.size()) {
                res.clear();
                res.addAll(stack);
            }
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

    private int checkPalindrome(String s, int i, int j) {
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
