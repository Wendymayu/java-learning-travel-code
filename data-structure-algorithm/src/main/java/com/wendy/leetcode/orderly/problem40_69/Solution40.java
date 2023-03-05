package com.wendy.leetcode.orderly.problem40_69;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        //int[] candidates = {1,2,3};
        int target = 8;
        List<List<Integer>> lists = new ArrayList<>();
        lists = combinationSum2(candidates, target);

        for (List<Integer> list : lists) {
            list.forEach(item -> System.out.print(item + " "));
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] used = new int[candidates.length];
        Arrays.sort(candidates);
        dfs(lists, path, 0, candidates, target, used);
        return lists;
    }

    public static void dfs(List<List<Integer>> lists, List<Integer> path, int begin, int[] candidates, int target, int[] used) {
        if (target == 0) {
            lists.add(new ArrayList<>(path));
            return;
        } else if (target < 0) {
            // 数值不满足的直接剪掉
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            //开始我用的 i>0,这会把不同层的相同元素也剪掉，比如会剪掉（1,1,6）
            //其实这个剪枝也可以用一个used数组来实现，90题我就是这样做的
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] <= target) {
                path.add(candidates[i]);
                //这里下次搜索从i+1开始，意味着如果前面有相同的元素，该点可以剪掉。开始我写成了begin+1,仍会出现（7,1）与（1,7）重复组合
                dfs(lists, path, i + 1, candidates, target - candidates[i], used);
                path.remove(path.size() - 1);
            }
        }

    }
}
