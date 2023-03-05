package com.wendy.leetcode.orderly.problem120_139;

import com.wendy.utils.ListUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/12/11 13:49
 * @Version 1.0
 */
public class Solution131 {
    public static void main(String[] args) {
       // String s = "aab";
        String s = "cbbbcc";
        List<List<String>> lists = partition(s);
        for (List list : lists) {
            ListUtils.printList(list);
        }
    }

    static public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
        // 注意：只使用 stack 相关的接口
        Deque<String> stack = new ArrayDeque<>();
        dfs(s, 0, s.length(), stack, res);
        return res;
    }

    static private void dfs(String s, int index, int len, Deque<String> stack, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<>(stack));
        } else {
            for (int i = index; i < len; i++) {
                if (checkPalindrome(s.substring(index, i + 1))) {
/*                    stack.addLast(s.substring(index, i + 1));
                    dfs(s, i + 1, len, stack, res);
                    stack.removeLast();*/
                    stack.push(s.substring(index, i + 1));
                    dfs(s, i + 1, len, stack, res);
                    stack.pop();
                }
            }
        }
    }

    static private boolean checkPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

