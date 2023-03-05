package com.wendy.leetcode.orderly.problem200_209;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/8/25 23:33
 * @Version 1.0
 */
public class Solution204 {
    public int countPrimes(int n) {
        if(n==0 || n==1){
            return 0;
        }
        int res = 0;
        for(int i=2;i<n;i++){
            if(isPrime(i)){
                res++;
            }
        }
        return res;
    }
    public boolean isPrime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public int countPrimes2(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) 2* i < n) {
                    for (int j = 2 * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
