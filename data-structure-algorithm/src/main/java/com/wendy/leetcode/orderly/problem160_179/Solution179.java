package com.wendy.leetcode.orderly.problem160_179;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Solution179
 * @Description
 * @Author wendyma
 * @Date 2021/7/18 11:08
 * @Version 1.0
 */
public class Solution179 {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        String s = largestNumber(nums);
        System.out.println(s);

    }

    //方法一：找出所有的排列，再求出最大的
    static public String largestNumber(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, nums.length, 0, path, used, res);
        String[] s = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            String ss = "";
            for (int j = 0; j < res.get(i).size(); j++) {
                ss += res.get(i).get(j);
            }
            s[i] = ss;
        }
        //下面是降序排列数组的方式
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        //这也是降序排列数组的方式
        //Arrays.sort(s, Collections.reverseOrder());
        return s[0];
    }

    //答案太厉害了
    public String largestNumber2(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }

    //失败的深度优先搜索
   /* public List<String> allNumber(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        boolean[] isSelected = new boolean[];
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {

            }
        }
    }*/
    static private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used,
                            List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, path, used, res);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
