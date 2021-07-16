package com.ly.leetcode;

import java.util.List;

public class JzSolution25 {
    public void merge(ListNode l1, ListNode l2, ListNode result) {
        if (l1 == null && l2 == null) {
            return;
        }

        if (l1 == null) {
            result.next = l2;
            merge(l1, l2.next, result.next);
        } else if (l2 == null) {
            result.next = l1;
            merge(l1.next, l2, result.next);
        } else if (l1.val > l2.val) {
            result.next = l2;
            merge(l1, l2.next, result.next);
        } else {
            result.next = l1;
            merge(l1.next, l2, result.next);
        }
    }

    public ListNode merge1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode current = result;

        while (l1 != null || l2 != null) {

            if (l1 == null) {
                current.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                current.next = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                current.next = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                l1 = l1.next;
            }
            current = current.next;


        }
        return result.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        merge(l1, l2, root);
        return root.next;
    }

    public static void main(String[] args) {
        ListNode l12 = new ListNode(4, null);
        ListNode l11 = new ListNode(2, l12);
        ListNode l10 = new ListNode(1, l11);

        ListNode l22 = new ListNode(4, null);
        ListNode l21 = new ListNode(3, l22);
        ListNode l20 = new ListNode(1, l21);

        ListNode node = new JzSolution25().mergeTwoLists(l10, l20);
        System.out.println("hello");
    }
}
