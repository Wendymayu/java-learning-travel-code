package com.wendy.leetcode.orderly.problem100_119;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/8/29 23:14
 * @Version 1.0
 */
public class Solution111 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.right = new TreeNode(6);
        System.out.println(minDepth(root));
    }
    static public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }else if(root.left != null && root.right == null){
            return minDepth(root.left)+1;
        }else if(root.left == null && root.right != null){
            return minDepth(root.right)+1;
        }
        return Math.min(minDepth(root.left)+1,minDepth(root.right)+1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
