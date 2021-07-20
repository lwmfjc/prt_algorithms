package com.ly.leetcode;

import java.util.ArrayList;
import java.util.List;

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

public class Solution94 {

    public void inorderTraversal(List<Integer> list, TreeNode node) {
        if(node==null){
            return;
        }
        inorderTraversal(list,node.left);
        list.add(node.val);
        inorderTraversal(list,node.right);

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(list,root);
        return list;
    }

    public static void main(String[] args) {

    }
}
