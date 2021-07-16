package com.ly.leetcode;

public class Solution2 {

    /**
     * @param l1
     * @param l2
     * @param result
     * @param ahead  是否进位
     */
    public void add(ListNode l1, ListNode l2, ListNode result, boolean ahead) {
        //是否还有数值需要计算
        if (l1 == null && l2 == null && !ahead) {
            return;
        }
        ListNode newNode = new ListNode();
        int num1 = 0;
        int num2 = 0;
        if (l1 != null) {
            num1 = l1.val;
        }
        if (l2 != null) {
            num2 = l2.val;
        }
        //这里算出这一位得到的总和
        int valSum=num1 + num2 + (ahead ? 1 : 0);
        newNode.val = valSum % 10;
        //大于10则进一位
        ahead = valSum >= 10;
        result.next = newNode;
        //判断是否为空
        add(l1 == null ? null : l1.next, l2 == null ? null : l2.next, result.next, ahead);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        add(l1, l2, node, false);
        return node.next;
    }

    public static void main(String[] args) {
        //ListNode l12 = new ListNode(3, null);
        ListNode l16 = new ListNode(9, null);
        ListNode l15 = new ListNode(9, l16);
        ListNode l14 = new ListNode(9, l15);
        ListNode l13 = new ListNode(9, l14);
        ListNode l12 = new ListNode(9, l13);
        ListNode l11 = new ListNode(9, l12);
        ListNode l10 = new ListNode(9, l11);

        ListNode l23 = new ListNode(9, null);
        ListNode l22 = new ListNode(9, l23);
        ListNode l21 = new ListNode(9, l22);
        ListNode l20 = new ListNode(9, l21);

        ListNode node = new Solution2().addTwoNumbers(l10, l20);
        ListNode current = node;
        while (current != null) {
            System.out.printf("%3d", current.val);
            current = current.next;
        }
        System.out.println("hello");
    }
}
