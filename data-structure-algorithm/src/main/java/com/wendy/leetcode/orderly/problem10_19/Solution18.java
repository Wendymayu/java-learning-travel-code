package com.wendy.leetcode.orderly.problem10_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/9/12 12:33
 * @Version 1.0
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums,target,0,0,list,path);
        return list;
    }
    public static void dfs(int[] nums,int target,int depth,int begin,List<List<Integer>> list,List<Integer> path){
        if(depth==4 && target==0){
            list.add(new ArrayList<>(path));
            return;
        }else if(depth==4 && target!=0){
            return;
        }
        for(int i=begin;i<nums.length;i++){
            if(nums.length - i  < 4 - path.size())return;
            if(i>begin && nums[i]==nums[i-1]) continue;
            if(i < nums.length - 1 && nums[i] + (3 - path.size()) * nums[i + 1] > target)return;
            if(i < nums.length - 1 && nums[i] + (3 - path.size()) * nums[nums.length - 1] < target)continue;

            //cur +=nums[i];
            path.add(nums[i]);
            dfs(nums,target-nums[i],depth+1,i+1,list,path);
            path.remove(path.size()-1);
            //cur -= nums[i];
        }
    }
}
