package com.ly.leetcode;

import java.util.List;

/**
 * todo 还不会做
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = reverseList(head.next);
        ListNode node1 = new ListNode();
        node1.next = head;
        System.out.print("[" + head.val + "]");
        return node1;
    }

    public static void main(String[] args) {

        ListNode l24 = new ListNode(5, null);
        ListNode l23 = new ListNode(4, l24);
        ListNode l22 = new ListNode(3, l23);
        ListNode l21 = new ListNode(2, l22);
        ListNode l20 = new ListNode(1, l21);

        ListNode node = new Solution206().reverseList(l20);
        ListNode current = node;
        while (current != null) {
            System.out.printf("%3d", current.val);
            current = current.next;
        }
    }
}
