package com.ly.leetcode;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        //如果没有这个=赋值,那么只是方法栈里面的引用进行了交换,实际并没有
        root.left=invertTree(root.left);
        root.right=invertTree(root.right);

        return root;
    }
}
