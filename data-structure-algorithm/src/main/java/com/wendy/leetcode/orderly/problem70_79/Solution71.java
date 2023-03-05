package com.wendy.leetcode.orderly.problem70_79;

import java.util.Stack;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/9/16 23:04
 * @Version 1.0
 */
public class Solution71 {
    public static void main(String[] args) {
        String path = "/home/";
        String path1 =  "/../";
        String path2 =  "/home//foo/";
        String path3 =  "/a/./b/../../c/";
        System.out.println(simplifyPath(path2));
    }
    // 主要难点在于../..的处理
    static public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        for(int i=0;i<paths.length;i++){
            if(paths[i].equals("..")){
                if(!stack.empty()){
                    stack.pop();
                    stack.pop();
                }
            }else if(!paths[i].equals(".") && !paths[i].equals("")){
                stack.push("/");
                stack.push(paths[i]);
            }else {
                continue;
            }
        }
        String[] tmp = new String[stack.size()];
        for(int i=tmp.length-1;i>=0;i--){
            tmp[i]=stack.pop();
        }
        String s = "";
        for(int i=0;i<tmp.length;i++){
            s += tmp[i];
        }
        return s.equals("")?"/":s;
    }
}
