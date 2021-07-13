package com.ly.ch2_exp;

import java.util.PriorityQueue;

/**
 * 优先队列练习
 */
public class PriorityTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        priorityQueue.offer(3);
        priorityQueue.offer(13);
        priorityQueue.offer(2);
        priorityQueue.offer(10);
        priorityQueue.offer(8);
        priorityQueue.offer(19);
        while (!priorityQueue.isEmpty()){
            System.out.printf("%3d",priorityQueue.poll());
        }
    }
}
