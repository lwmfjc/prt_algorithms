package com.ly.leetcode;

/**
 * todo 这个用递归好像很难..
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        return false;
    }


    public static void main(String[] args) {

        ListNode l24 = new ListNode(1, null);
        ListNode l23 = new ListNode(2, l24);
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
