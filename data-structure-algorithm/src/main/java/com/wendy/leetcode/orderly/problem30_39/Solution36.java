package com.wendy.leetcode.orderly.problem30_39;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Solution36
 * @Description TODO
 * @Author wendyma
 * @Date 2021/7/13 22:54
 * @Version 1.0
 */
public class Solution36 {
    public static void main(String[] args) {
        char[] c = {'5','3','.','.','7','.','.','.','.'};
        System.out.println(isRepeat(c));
        char[][] board =  {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        for(int i=0;i<9;i++){
            System.out.println(isRepeat(board[i]));
        }
        System.out.println(isValidSudoku(board));

    }
    static public boolean isValidSudoku(char[][] board) {
        //char[] temp = new char[9];
        for (int i = 0; i < 9; i++) {
            if (!isRepeat(board[i]))
                return false;
        }
        for (int i = 0; i < 9; i++) {
            char[] temp = new char[9];
            for (int j = 0; j < 9; j++) {
                temp[j] = board[j][i];
            }
            if (!isRepeat(temp))
                return false;
           /* for(int j=0;j<9;j++){
                temp[j] = '.';
            }*/
        }
        int[][] xy = {{0,0},{0,3},{0,6},{3,0},{3,3},{3,6},{6,0},{6,3},{6,6}};

        for(int i=0;i<9;i++){
            char[] temp = new char[9];
            List<Character> list = new ArrayList<>();
            for(int j=xy[i][0];j<xy[i][0]+3;j++){
                for(int k=xy[i][1];k<xy[i][1]+3;k++){
                    list.add(board[j][k]);
                }
            }
            for(int j=0;j<9;j++){
                temp[j] = list.get(j);
            }
            if(!isRepeat(temp))
                return false;
           /* for(int j=0;j<9;j++){
                temp[j] = '.';
            }*/
        }
        return true;
    }

    static public boolean isRepeat(char[] c) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            if (c[i] == '.') {
                map.put('.', map.getOrDefault('.', 0)+1);
            } else {
                map.put(c[i], 0);
            }
        }
        if(map.get('.')!=null){
            if ((9 - map.get('.')) == map.size()-1) {
                return true;
            }
        }else if(map.size()==9){
            return true;
        }
        return false;
    }
}
