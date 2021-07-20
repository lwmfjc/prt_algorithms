package com.ly.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution144 {
    public void preorderTraversal(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preorderTraversal(list, node.left);
        preorderTraversal(list, node.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(list, root);
        return list;
    }
}
