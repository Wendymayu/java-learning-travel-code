package com.wendy.algorightm.dynamic_programming;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/7/13 22:50
 * @Version 1.0
 */
public class ZeroOneBag {

    /**
     * @param W      背包容量
     * @param N      物品个数
     * @param weight 每个物品的重量
     * @param value  每个物品的价值
     * @return
     */
    static public int getMaxValue(int W, int N, int[] weight, int[] value) {
        int[][] dp = new int[N + 1][W + 1];
        // i=0或j=0的初始化自动满足

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        //则容量为V的背包能够装入物品的最大值为
        int maxValue = dp[N][W];
        //逆推找出装入背包的所有商品的编号
        int j = W;
        String numStr = "";
        for (int i = N; i > 0; i--) {
            //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
            if (dp[i][j] > dp[i - 1][j]) {
                numStr = i + " " + numStr;
                j = j - weight[i - 1];
            }
            if (j == 0)
                break;
        }
        System.out.println(numStr);

        return dp[N][W];
    }

    /**
     * 我的解法，初始化第0行，即只有1个产品可选时的价值
     * @param W
     * @param N
     * @param weight
     * @param value
     * @return
     */
    static public int getMaxValue2(int W, int N, int[] weight, int[] value) {
        int[][] dp = new int[N][W + 1];
        for (int i = 0; i < N; i++) {
            dp[i][0] = 0;
        }
        // 只有第0个物品可选时
        for (int i = 0; i <= W; i++) {
            if (weight[0] <= i) {
                dp[0][i] = value[0];
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= W; j++) {
                if (weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[N - 1][W];
    }

    public static void main(String[] args) {
        int N = 5;//物品有五件
        int W = 21;//背包容量为20
        int weight[] = {2, 3, 4, 5, 9};//重量 2 3 4 5 9
        int value[] = {3, 4, 5, 8, 10};//价值3 4 5 8 10
//        System.out.println(getMaxValue(W, N, weight, value));
        System.out.println(getMaxValue2(W, N, weight, value));
    }

}
