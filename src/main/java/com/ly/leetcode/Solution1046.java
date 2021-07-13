package com.ly.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                Comparator.reverseOrder()
        );
        for (int i : stones) {
            //offer +;peek ;poll
            priorityQueue.offer(i);
        }
        while (priorityQueue.size() > 1) {
            int a1 = priorityQueue.poll();
            int a2 = priorityQueue.poll();
            priorityQueue.offer(Math.abs(a1 - a2));
        }
        if (priorityQueue.isEmpty()) {
            return 0;
        } else {
            return priorityQueue.poll();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1046().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));

    }
}
