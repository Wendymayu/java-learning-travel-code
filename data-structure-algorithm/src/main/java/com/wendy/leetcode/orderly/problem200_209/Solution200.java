package com.wendy.leetcode.orderly.problem200_209;

public class Solution200 {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int num = 0;
         for(int i=0;i<grid.length;i++){
             for(int j=0;j<grid[0].length;j++){
                 if(grid[i][j]=='1'){
                     num++;
                     dfs(grid,i,j);
                 }
             }
         }
         return num;
    }
    public static void dfs(char[][] grid,int x,int y){
        //注意递归结束条件一定要用字符变量 '0'
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]=='0'){
            return;
        }
        //此处一定要用'0',不然上述递归终止条件不满足。会导致下面dfs(grid,x+1,y)和dfs(grid,x-1,y)两个方法来回调用
       //然后方法栈空间就不够用了，报StackOverflowError
        grid[x][y] = '0';
        dfs(grid,x+1,y);
        dfs(grid,x-1,y);
        dfs(grid,x,y+1);
        dfs(grid,x,y-1);
    }
}
