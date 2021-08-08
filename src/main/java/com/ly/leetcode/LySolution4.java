package com.ly.leetcode;

import com.ly.ch1.Stack;

public class LySolution4 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        boolean isEndLeft = false;
        TreeNode lastNode = null;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (isEndLeft) {
                lastNode.left = pop;
                lastNode = pop;
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.left == null && !isEndLeft) {
                isEndLeft = true;
                lastNode = pop;
            }

        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop.left != null) {
                stack.push(pop.left);
            }
            pop.right = pop.left;
            pop.left = null;
        }

        print(root);
    }

    public void flatten1(TreeNode root) {
        TreeNode newRoot = new TreeNode(root.val);
        TreeNode current = newRoot;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            //System.out.print(pop.val + " ");
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
            TreeNode temp = new TreeNode(pop.val);
            current.right = temp;
            current = temp;
        }
        root = newRoot;
        print(root);
    }

    private void print(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val + " ");
        print(node.left);
        print(node.right);
    }

    public static void main(String[] args) {

        TreeNode l221 = new TreeNode(17);
        TreeNode l21 = new TreeNode(15);
        TreeNode l22 = new TreeNode(6, null, null);
        TreeNode l11 = new TreeNode(3);
        TreeNode l12 = new TreeNode(4);
        TreeNode l1 = new TreeNode(2, l11, l12);
        TreeNode l2 = new TreeNode(5, null, l22);
        TreeNode root = new TreeNode(1, l1, l2);
        LySolution4 solution4 = new LySolution4();
        solution4.flatten(root);
        //solution4.print(root);

        System.out.println();
    }
}
