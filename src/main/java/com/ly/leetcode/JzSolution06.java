package com.ly.leetcode;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;

public class JzSolution06 {
    public void reversePrint(ListNode head, ArrayList<Integer> arrys) {
        if (head == null) {
            return;
        }
        reversePrint(head.next, arrys);
        arrys.add(head.val);

    }

    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> integers = new ArrayList<>();
        reversePrint(head, integers);
        int[] ints = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            ints[i] = integers.get(i);
        }
        return ints;
    }

    public static void main(String[] args) {

    }
}
