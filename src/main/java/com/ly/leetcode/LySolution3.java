package com.ly.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//抄的题解
public class LySolution3 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> array = new ArrayList<>();
        // dfs(root, null, 0);
        if (root == null) {
            return array;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //System.out.print(root.val + " ");
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int i = queue.size();
            for (int j = 0; j < i; j++) {
                TreeNode nodeTemp = queue.poll();
                level.add(nodeTemp.val);
                if(nodeTemp.left!=null) {
                    queue.offer(nodeTemp.left);
                }
                if(nodeTemp.right!=null) {
                    queue.offer(nodeTemp.right);
                }
            }
            array.add(0, level);
        }
        return array;
    }

    public static void main(String[] args) {

    }
}
