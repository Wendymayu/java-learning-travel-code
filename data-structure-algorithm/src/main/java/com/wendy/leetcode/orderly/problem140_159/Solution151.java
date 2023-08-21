package com.wendy.leetcode.orderly.problem140_159;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/16 22:45
 * @Version 1.0
 */
public class Solution151 {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(s.hashCode());
        System.out.println(appendSr(s));
        System.out.println(s);
        System.out.println(s.hashCode());

    }

    public static  String appendSr(String s){
        System.out.println(s.hashCode());
        s+="bbb";
        System.out.println(s);
        System.out.println(s.hashCode()+"--------------");
        return s;
    }

    public String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].trim().length() > 0) {
                sb.append(strings[i].trim());
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
