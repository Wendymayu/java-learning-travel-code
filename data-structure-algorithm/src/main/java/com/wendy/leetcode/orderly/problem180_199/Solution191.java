package com.wendy.leetcode.orderly.problem180_199;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/8/25 20:00
 * @Version 1.0
 */
public class Solution191 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(-3));
    }
    static public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int num = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                num++;
            }
        }
        return num;
    }
}
