package com.wendy.leetcode.orderly.problem20_29;

import java.util.Scanner;

public class Solution29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(divide(a,b));
        }
    }
    public static int divide(int dividend, int divisor) {
        int res = 0;
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        /*if(Math.abs(dividend+divisor)<Math.abs(dividend)+Math.abs(divisor)){
            flag= -1;
        }*/
        boolean flag = (dividend ^ divisor)>=0;
        Integer a = -Math.abs(dividend);

        int b = -Math.abs(divisor);
        while(a<=b){
            int temp = b;
            int n = 1;
            while(a-temp<=temp){
               temp = temp<<1;
               n = n<<1;
            }
            res+=n;
            a -= temp;
        }
        return flag?res:0-res;
    }
}
