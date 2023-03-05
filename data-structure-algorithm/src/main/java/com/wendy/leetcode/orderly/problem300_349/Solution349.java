package com.wendy.leetcode.orderly.problem300_349;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Solution349
 * @Description 给定两个数组，编写一个函数来计算它们的交集。
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * @Author wendyma
 * @Date 2021/7/18 15:59
 * @Version 1.0
 */
public class Solution349 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] result = intersection(nums1,nums2);
        for(int item:result){
            System.out.println(item);
        }
    }
   static public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            list.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(list.contains(nums2[i])){
                set.add(nums2[i]);
            }
        }
        int[] result = new int[set.size()];
        Object[] setArray = set.toArray();
        for(int i=0;i<set.size();i++){
            result[i] = (int)setArray[i];
        }
        return result;
    }
}
