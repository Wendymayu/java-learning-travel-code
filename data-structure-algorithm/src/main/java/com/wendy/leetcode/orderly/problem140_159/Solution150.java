package com.wendy.leetcode.orderly.problem140_159;

import java.util.Stack;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/20 13:56
 * @Version 1.0
 */
public class Solution150 {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }

    static public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = Integer.parseInt(tokens[0]);
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+")) {
                int first = stack.pop();
                int second = stack.pop();
                res = second + first;
                stack.push(res);
            } else if (s.equals("-")) {
                int first = stack.pop();
                int second = stack.pop();
                res = second - first;
                stack.push(res);
            } else if (s.equals("*")) {
                int first = stack.pop();
                int second = stack.pop();
                res = second * first;
                stack.push(res);
            } else if (s.equals("/")) {
                int first = stack.pop();
                int second = stack.pop();
                res = second / first;
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return res;
    }
}
