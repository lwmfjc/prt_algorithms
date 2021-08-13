package com.ly.leetcode;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution98 {
    ArrayList<Integer> array = new ArrayList<>();

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            array.add(node.val);
            return;
        }
        dfs(node.left);
        array.add(node.val);
        dfs(node.right);
    }

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        if (array.size() == 1) {
            return true;
        }
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) <= array.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidBST1(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode deNode = queue.poll();
            if (deNode.left == null && deNode.right == null) {
                continue;
            }

            if (deNode.left != null && deNode.left.val >= deNode.val) {
                return false;
            }
            if (deNode.right != null && deNode.right.val <= deNode.val) {
                return false;
            }
            if (deNode.left != null) {
                queue.offer(deNode.left);
            }
            if (deNode.right != null) {
                queue.offer(deNode.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode l21 = new TreeNode(3);
        TreeNode l22 = new TreeNode(6);
        TreeNode l11 = new TreeNode(10);
        TreeNode l12 = new TreeNode(2);
        TreeNode l1 = new TreeNode(1, null, null);
        TreeNode l2 = new TreeNode(4, l21, l22);
        TreeNode root = new TreeNode(5, l1, l2);
        System.out.println(new Solution98().isValidBST(root));
    }
}
