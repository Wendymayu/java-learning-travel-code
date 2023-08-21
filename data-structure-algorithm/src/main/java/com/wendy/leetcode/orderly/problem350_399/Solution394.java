package com.wendy.leetcode.orderly.problem350_399;

import java.util.Stack;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/12 21:23
 * @Version 1.0
 */
public class Solution394 {
    public static void main(String[] args) {
        //String s = "3[a2[c]]";
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    static public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ']') {
                // 弹出字符串
                String temp = stack.pop();

                // 弹出'['
                stack.pop();

                String topNum = stack.pop();
                String s1 = "";
                if (topNum != null) {
                    int num = Integer.parseInt(topNum);
                    for (int i = 0; i < num; i++) {
                        s1 += temp;
                    }
                    mergeString(stack, s1);
                }
            } else if ('0' <= c && c <= '9') {
                // 合并多位数字
                if (!stack.isEmpty() && isNumeric(stack.peek())) {
                    String top = stack.pop();
                    stack.push(top + "" + c);
                } else {
                    stack.push(c + "");
                }

            } else if ('a' <= c && c <= 'z') {
                mergeString(stack, c + "");
            } else {
                stack.push(c + "");
            }
        }
        return stack.pop();
    }

    private static void mergeString(Stack<String> stack, String s) {
        while (!stack.isEmpty() && !isNumeric(stack.peek()) && !stack.peek().equals("[")) {
            String top = stack.pop();
            s = top + s;
        }
        stack.push(s);
    }

    static public boolean isNumeric(String str) {
        return str != null && str.chars().allMatch(Character::isDigit);
    }
}
