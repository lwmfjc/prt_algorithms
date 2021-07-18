package com.ly.leetcode;

import java.util.List;

public class JzSolution24 {
    public ListNode reverseList(ListNode head) {
        //长度为0或1的链表
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newNode=reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public static void main(String[] args) {
      /*  ListNode l24 = new ListNode(5, null);
        ListNode l23 = new ListNode(4, l24);*/
        ListNode l22 = new ListNode(3, null);
        ListNode l21 = new ListNode(2, l22);
        ListNode l20 = new ListNode(1, l21);

        ListNode node = new JzSolution24().reverseList(l20);
        ListNode current = node;
        while (current != null) {
            System.out.printf("%3d", current.val);
            current = current.next;
        }
    }
}
