package com.wendy.leetcode.orderly.problem120_139;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/9/12 12:30
 * @Version 1.0
 */
public class Solution130 {
    public void solve(char[][] board) {
        if(board==null || board.length==0) return;
        int[][] used = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0 || i==board.length-1 || j==0 || j==board[0].length-1){
                    dfs(used,board,i,j);
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(used[i][j]==1){
                    board[i][j]='O';
                }else{
                    board[i][j]='X';
                }
            }
        }
    }
    public static void dfs(int[][] used,char[][] board,int x,int y){
        if(x<0 || y<0 || x>=board.length || y>=board[0].length || board[x][y]=='X') return;

        used[x][y] = 1;
        board[x][y]='X';
        dfs(used,board,x+1,y);
        dfs(used,board,x-1,y);
        dfs(used,board,x,y+1);
        dfs(used,board,x,y-1);
    }
}
