package com.ly.leetcode;

public class Solution21 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //数都取完了,停止递归计算
        if (l1 == null && l2 == null) {
            return null;
        }
        int val = 0;
        ListNode next1 = l1;
        ListNode next2 = l2;
        //判断该取哪个值
        //被取值的链表,跳到下一个值
        if (l1 == null) {
            val = l2.val;
            next2 = l2.next;
        } else if (l2 == null) {
            val = l1.val;
            next1 = l1.next;
        } else if (l2.val > l1.val) {
            val = l1.val;
            next1 = l1.next;
        } else {
            val = l2.val;
            next2 = l2.next;
        }
        return new ListNode(val, mergeTwoLists(next1, next2));
    }

    public static void main(String[] args) {
        ListNode l12 = new ListNode(4, null);
        ListNode l11 = new ListNode(2, l12);
        ListNode l10 = new ListNode(1, l11);

        ListNode l22 = new ListNode(4, null);
        ListNode l21 = new ListNode(3, l22);
        ListNode l20 = new ListNode(1, l21);

        ListNode node = new Solution21().mergeTwoLists(l10, l20);
        ListNode current = node;
        while (current != null) {
            System.out.printf("%3d", current.val);
            current = current.next;
        }
    }
}
