package com.ly.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution104 {
    //最大深度
    public int maxDepth(TreeNode node) {
        int maxDeep = 0;
        if (node == null) return maxDeep;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(node);
        maxDeep++;
        while (!nodes.isEmpty()) {
            TreeNode node1 = nodes.poll();
            if (node1 == null) {
                continue;
            }

            System.out.print(node1.val + " ");

            if (node1.left != null) {
                nodes.offer(node1.left);
            }
            if (node1.right != null) {
                nodes.offer(node1.right);
            }
            if (node1.left != null || node1.right != null) {
                maxDeep++;
            }
        }
        //  System.out.print(maxDeep);
        return maxDeep;
    }

    //层次遍历
    public static void printLevel(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(node);
        int maxDeep = 1;
        while (!nodes.isEmpty()) {
            TreeNode node1 = nodes.poll();
            if (node1 == null) {
                continue;
            }

            System.out.print(node1.val + " ");

            if (node1.left != null) {
                nodes.offer(node1.left);
            }
            if (node1.right != null) {
                nodes.offer(node1.right);
            }
            if (node1.left != null && node1.right != null) {
                maxDeep++;
            }
        }
        System.out.print(maxDeep);
    }

    //中序遍历
    public void print(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(node);
        while (!nodes.isEmpty()) {
            TreeNode node1 = nodes.pop();
            System.out.print(node1.val + " ");
            if (node1.right != null) {
                nodes.push(node1.right);
            }
            if (node1.left != null) {
                nodes.push(node1.left);
            }

        }
    }

    public static void main(String[] args) {
        TreeNode l221 = new TreeNode(17);
        TreeNode l21 = new TreeNode(15);
        TreeNode l22 = new TreeNode(7, l221, null);
        TreeNode l11 = new TreeNode(10);
        TreeNode l12 = new TreeNode(2);
        TreeNode l1 = new TreeNode(9, l11, l12);
        TreeNode l2 = new TreeNode(20, l21, l22);
        TreeNode root = new TreeNode(3, l1, l2);


         new Solution104().print(root) ;
        // System.out.print(new Solution404().sumOfLeftLeaves(root));


    }
}
