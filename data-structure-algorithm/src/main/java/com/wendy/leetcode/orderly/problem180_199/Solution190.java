package com.wendy.leetcode.orderly.problem180_199;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/8/25 21:30
 * @Version 1.0
 */
public class Solution190 {
    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }
    static public int reverseBits(int n) {
        StringBuilder s = new StringBuilder(Integer.toBinaryString(n));
        int len = 32-s.length();
        String s1 = s.reverse().toString();
        //短与32的需要补0
        for(int i=0;i<len;i++){
            s1+="0";
        }
        //二进制字符串不能直接转化为10进制数字
        //int res = Integer.parseInt("11111111111111111111111111111101",2);

        int res = 0;
        char[] arr = s1.toString().toCharArray();
        if(arr[0] == 1){
            for(int i = 1;i<arr.length;i++){
                if(arr[i] == 1){
                    arr[i] = 0;
                }
                else{
                    arr[i] = 1;
                }
            }
        }
        for (char c : arr) {
            res = res * 2 + (c == '1' ? 1 : 0);
        }
        return res;
    }
}
