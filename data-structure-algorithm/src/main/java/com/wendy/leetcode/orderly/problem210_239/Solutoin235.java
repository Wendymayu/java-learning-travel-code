package com.wendy.leetcode.orderly.problem210_239;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/8/31 22:16
 * @Version 1.0
 */
public class Solutoin235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(isCommonAncestor(root,p,q)&&!isCommonAncestor(root.left,p,q)&&!isCommonAncestor(root.right,p,q)){
            return root;
        }else if(isCommonAncestor(root,p,q)&&!isCommonAncestor(root.left,p,q)){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return lowestCommonAncestor(root.left,p,q);
        }
    }

    public boolean isCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(isAncestor(root,p) && isAncestor(root,q)){
            return true;
        }
        return false;
    }


    public boolean isAncestor(TreeNode root, TreeNode p){
        if(root ==null) return false;
        if(root.equals(p)){
            return true;
        }
        return isAncestor(root.left,p) || isAncestor(root.right,p);
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