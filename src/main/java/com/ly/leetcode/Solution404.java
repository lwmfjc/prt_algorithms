package com.ly.leetcode;

import sun.reflect.generics.tree.Tree;

public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;//空
        }
        if (root.right == null && root.left == null) {
            return 1;//是叶子
        }

        return sumOfLeftLeaves(root.left) ;


    }

    public static void main(String[] args) {
        TreeNode l21 = new TreeNode(15);
        TreeNode l22 = new TreeNode(7);
        TreeNode l11 = new TreeNode(10);
        TreeNode l12 = new TreeNode(2);
        TreeNode l1 = new TreeNode(9, null, null);
        TreeNode l2 = new TreeNode(20, l21, l22);
        TreeNode root = new TreeNode(3, l1, l2);
        System.out.print(new Solution404().sumOfLeftLeaves(root));

    }
}
