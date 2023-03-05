package com.wendy.leetcode.orderly.problem40_69;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution49
 * @Description TODO
 * @Author wendyma
 * @Date 2021/7/12 22:35
 * @Version 1.0
 */
public class Solution49 {
    public static void main(String[] args) {
        //String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = {"","b"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            List<String> list = new ArrayList<>();
            if(strs[i]!=null){
                list.add(strs[i]);
                for(int j=i+1;j<strs.length;j++){
                    if(isAnagrams(strs[i],strs[j])){
                        list.add(strs[j]);
                        strs[j]=null;
                    }
                }
                lists.add(list);
            }

        }
        return lists;

    }


    public static boolean isAnagrams(String s1,String s2){
        if(s1==null || s2==null ||s1.length()!=s2.length()){
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        //我想比较两个字符数组构成的字符串是否相同，发现不能通过toString将其转化为字符串
        /*if(c1.toString().equals(c2.toString())){
            return true;
        }*/
        //无奈比较每一个字母 字符串有下面这个构造
       // String key = new String(c1);
        for(int i=0;i<c1.length;i++){
            if(c1[i]!=c2[i]){
                return false;
            }
        }


        return true;
    }

    //agg和gaa是不同的，我下面判断方法有误
    public static boolean isAnagrams1(String s1,String s2){
        if(s1==null || s2==null){
            return false;
        }
        for(int i=0;i<s1.length();i++){
            if(!s2.contains(s1.substring(i,i+1))){
                return false;
            }
        }
        for(int i=0;i<s2.length();i++){
            if(!s1.contains(s2.substring(i,i+1))){
                return false;
            }
        }
        return true;
    }
}
