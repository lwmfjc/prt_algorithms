package com.ly.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MsSolution0304 {
    /**
     * Initialize your data structure here.
     */
    public MsSolution0304() {

    }
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();


    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return s1.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return s1.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        MsSolution0304 queue = new MsSolution0304();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());  // 返回 1
        System.out.println(queue.pop());   // 返回 1
        queue.empty(); // 返回 false
    }
}
