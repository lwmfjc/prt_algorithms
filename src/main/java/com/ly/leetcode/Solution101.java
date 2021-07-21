package com.ly.leetcode;

/**
 * todo 还不会写
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return false;
    }

    public static void main(String[] args) {
        TreeNode l21 = new TreeNode(15);
        TreeNode l22 = new TreeNode(7);
        TreeNode l11 = new TreeNode(10);
        TreeNode l12 = new TreeNode(2);
        TreeNode l1 = new TreeNode(9, l11, l12);
        TreeNode l2 = new TreeNode(20, l21, l22);
        TreeNode root = new TreeNode(3, l1, l2);
        System.out.print(new Solution404().sumOfLeftLeaves(root));

    }
}
