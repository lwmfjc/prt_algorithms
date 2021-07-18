package com.ly.leetcode;

import java.util.List;

/**
 * todo 还不会做
 */
public class Solution206 {
    /**
     * 下面以1 2 3 4 5举例
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //如果head就是null
        if (head== null || head.next == null ) {
            return head;
        }
        //这里注意哦,别被递归绕晕了,该方法返回一个指针
        // 这个递归到head==4的时候结束,
        //因为此时进判断条件时,head=4.next
        // head.next==null,返回head 为5,

        //所以4的时候,返回的newHead指向5
        //3的时候返回的newHead指向4所指
        //同理，1也是

        ListNode newHead = reverseList(head.next);

        //★这时候每个方法栈的引用都已经复制完毕了,等待调用

        // 然后就是一层层处理结点下一个结点(反向)指向该结点,
        // 以及结点的下一个结点设置为空
        head.next.next=head;
        head.next=null;

        return newHead;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode current = head;
        ListNode last = null;
        while (current != null) {
            ListNode tempNext = current.next;
            current.next = last;
            last = current;
            current = tempNext;
        }
        return last;
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
