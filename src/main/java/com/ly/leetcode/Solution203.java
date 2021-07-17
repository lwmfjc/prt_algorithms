package com.ly.leetcode;

public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        //当前结点的下一个结点,取决于下一个结点的val
        head.next = removeElements(head.next, val);

        //对于第一个结点,如果第一个结点为删除的值,第一个结点指向.next
        //为什么要返回这个值,这个返回值,就是为上一个结点服务的,决定了上一个结点的下一个结点
        return head.val == val ? head.next : head;

    }

    public static void main(String[] args) {

        ListNode l24 = new ListNode(5, null);
        ListNode l23 = new ListNode(4, l24);
        ListNode l22 = new ListNode(3, l23);
        ListNode l21 = new ListNode(2, l22);
        ListNode l20 = new ListNode(1, l21);

        ListNode node = new Solution203().removeElements(l20, 3);
        ListNode current = node;
        System.out.println("\n--------------");
        while (current != null) {
            System.out.printf("%3d", current.val);
            current = current.next;
        }
    }
}
