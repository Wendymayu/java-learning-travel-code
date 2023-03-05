package com.wendy.leetcode.orderly.problem100_119;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/8/30 23:35
 * @Version 1.0
 */
public class Solution112 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        System.out.println(hasPathSum(root,2));
    }
    static public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        int val = root.val;
        if(root.left==null && root.right==null){
            if(targetSum==val){
                return true;
            }else{
                return false;
            }
        }else if(root.left!=null && root.right==null){
            return hasPathSum(root.left,targetSum-val);
        }else if(root.left==null && root.right!=null){
            return hasPathSum(root.right,targetSum-val);
        }

        return hasPathSum(root.left,targetSum-val) || hasPathSum(root.right,targetSum-val);
    }
}
