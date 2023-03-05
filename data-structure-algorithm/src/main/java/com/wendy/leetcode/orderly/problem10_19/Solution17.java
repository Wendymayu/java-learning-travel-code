package com.wendy.leetcode.orderly.problem10_19;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    public static void main(String[] args) {

    }
    private String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.equals("")) return new ArrayList<String>();
        List<String> list = new ArrayList<>();
        StringBuffer s = new StringBuffer();
        dfs(list,digits,s,0);
        return list;
    }
    public  void dfs(List<String> list,String digits,StringBuffer s,int index){
        if(s.length()==digits.length()){
            list.add(s.toString());
            return;
        }
        String s1 = map[digits.charAt(index)-'2'];
        for(char ch:s1.toCharArray()) {
            s.append(ch);
            dfs(list,digits,s,index+1);
            s.deleteCharAt(s.length()-1);
        }

    }
}
