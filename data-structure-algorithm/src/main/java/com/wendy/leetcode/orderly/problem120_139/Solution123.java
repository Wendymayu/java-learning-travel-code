package com.wendy.leetcode.orderly.problem120_139;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/23 21:24
 * @Version 1.0
 */
public class Solution123 {
    public static void main(String[] args) {
       // int[] prices = {3,3,5,0,0,3,1,4};
       // int[] prices = {1,2 ,3,4,5};
        int[] prices = {1,2,4,2,5,7,2,4,9,0}; //无法通过
        Solution123 solution123 = new Solution123();
        System.out.println(solution123.maxProfit(prices));
    }

    /**
     * 我的解法
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        List<Deal> list = new ArrayList<>();
        int buyDay = 0;
        int sellDay = -1;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[buyDay]) {
                buyDay = i;
            } else if (prices[i] > prices[buyDay]) {
                sellDay = i;
                int profit = prices[sellDay] - prices[buyDay];
                Deal deal = new Deal(prices[buyDay], buyDay, prices[sellDay], sellDay, profit);
                deal = mergeDeal(deal, list);
                list.add(deal);
                buyDay = i;
            }
        }
        list = list.stream()
                .sorted(((o1, o2) -> o2.profit - o1.profit
                )).collect(Collectors.toList());

        if (list.size() == 0) {
            return 0;
        } else if (list.size() == 1) {
            return list.get(0).profit;
        } else {
            return list.get(0).profit + list.get(1).profit;
        }
    }

    // 如果两个交易的卖出日和买入是同一天，这俩交易可以合并
    private Deal mergeDeal(Deal deal, List<Deal> list) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).sellDay == deal.buyDay) {
                deal.buyDay = list.get(i).buyDay;
                deal.buyPrice = list.get(i).buyPrice;
                deal.profit = list.get(i).profit + deal.profit;
                index = i;
                break;
            }
        }
        if (index >= 0) {
            list.remove(index);
        }
        return deal;
    }

    class Deal {
        int buyPrice;
        int buyDay;
        int sellPrice;
        int sellDay;
        int profit;

        Deal(int buyPrice, int buyDay, int sellPrice, int sellDay, int profit) {
            this.buyPrice = buyPrice;
            this.buyDay = buyDay;
            this.sellPrice = sellPrice;
            this.sellDay = sellDay;
            this.profit = profit;
        }
    }
}
