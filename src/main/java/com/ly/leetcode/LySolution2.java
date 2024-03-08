package com.ly.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LySolution2 {
    int indexTotal = 0;

    private void dfs(TreeNode root, TreeNode lastNode, int index) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        dfs(root.left, root, ++index);
        dfs(root.right, root, ++index);

    }

    public int sumNumbers(TreeNode root) {
       // dfs(root, null, 0);
        if (root == null) {
            return 0;
        }
        ArrayList<ArrayList<Integer>> arrayTotal
                = new ArrayList<>( );

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //System.out.print(root.val + " ");
        while (!queue.isEmpty()) {
            TreeNode nodeTemp = queue.poll();
            //arrayTotal.add(new ArrayList<>());

            System.out.print(nodeTemp.val+" ");
            if (nodeTemp.left == null && nodeTemp.right == null) {
                continue;
            }
            queue.offer(nodeTemp.left);
            queue.offer(nodeTemp.right);

        }
        /*for (int m = 0; m < arrayTotal.size(); m++) {
            for (int n = 0; n < arrayTotal.get(m).size(); n++) {
                System.out.print(arrayTotal.get(m).get(n)+" ");
            }
            System.out.println();
        }*/
        return -1;
    }

    public static void main(String[] args) {

        TreeNode l221 = new TreeNode(17);
        TreeNode l21 = new TreeNode(15);
        TreeNode l22 = new TreeNode(7, l221, null);
        TreeNode l11 = new TreeNode(5);
        TreeNode l12 = new TreeNode(1);
        TreeNode l1 = new TreeNode(9, l11, l12);
        TreeNode l2 = new TreeNode(0, null, null);
        TreeNode root = new TreeNode(4, l1, l2);
        LySolution2 solution2 = new LySolution2();
        System.out.println("----------");
        solution2.sumNumbers(root);

    }
}
