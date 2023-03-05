package com.wendy.leetcode.orderly.problem40_69;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/9/4 23:04
 * @Version 1.0
 */
public class Solution57 {
    public static void main(String[] args) {
       int[][] intervals = {{1,3},{6,9}};// pass
       int[] newInterval = {2,5};

        int[][] intervals2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};// pass
        int[] newInterval2 = {4,8};

        int[][] intervals3 = {};// pass
        int[] newInterval3 = {5,7};

        int[][] intervals4 = {{1,5}};// pass
        int[] newInterval4 = {2,3};
       int[][] res = insert(intervals3,newInterval3);
       for(int i=0;i<res.length;i++){
           System.out.println(res[i][0]+"  "+res[i][1]);
       }
    }
    static public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int index = 0;
        for(int i=0;i<len;i++){
            if(intervals[i][0]<=newInterval[0]){
                index = i+1;
            }else{
                break;
            }
        }

        //把老数组和插入值拷贝到新数组
        int[][] tmp = new int[len+1][2];
        for(int i=0;i<len+1;i++){
            if(i<index){
                tmp[i][0] = intervals[i][0];
                tmp[i][1] = intervals[i][1];
            }else if(i>index){
                tmp[i][0] = intervals[i-1][0];
                tmp[i][1] = intervals[i-1][1];
            }else{
                tmp[index][0] = newInterval[0];
                tmp[index][1] = newInterval[1];
            }
        }
        int numberOfMerge = 0;
        for(int i=0;i<len;i++){
            if(tmp[i][1]>=tmp[i+1][0]){
                int right = tmp[i+1][1];
                if(tmp[i][1]>tmp[i+1][1]){
                    right = tmp[i][1];
                }
                tmp[i+1][0] = tmp[i][0];
                tmp[i+1][1] = right;
                tmp[i][0] =-1;
                tmp[i][1]=-1;
                numberOfMerge++;
            }
        }
        int[][] res = new int[len+1-numberOfMerge][2];
        int j=0;
        for(int i=0;i<len+1;i++){
            if(tmp[i][0]!=-1){
                res[j][0] = tmp[i][0];
                res[j][1] = tmp[i][1];
                j++;
            }
        }
        return res;
    }
}
/*
    int left = -1;
    int right = intervals.length;
    int len = intervals.length;
        for(int i=0;i<intervals.length;i++){
        if(intervals[i][0]<=newInterval[0] && newInterval[1]<=intervals[i][1]){
        left = i;
        }
        if(intervals[i][0]<=newInterval[0] && newInterval[1]<=intervals[i][1]){
        right = i;
        break;
        }
        }
        if(left==right && left==-1){
        int[][] res = new int[intervals.length][2];
        res[0][0] = newInterval[0];
        res[0][1] = newInterval[1];
        for(int i=1;i<res.length;i++){
        res[i][0] = intervals[i-1][0];
        res[i][1] = intervals[i-1][1];
        }
        }else if(left==right && right==len){
        int[][] res = new int[intervals.length][2];
        res[len][0] = newInterval[0];
        res[len][1] = newInterval[1];
        for(int i=0;i<len;i++){
        res[i][0] = intervals[i][0];
        res[i][1] = intervals[i][1];
        }
        }else {
        if(left!=-1){
        int newLeft = newInterval[0]<
            }else{

                    }
                    }*/
