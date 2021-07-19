package com.ly.leetcode;

public class MsSolution0206 {

    public boolean isPalindrome1(ListNode head) {
        //现将链表反转
        ListNode current = head;
        ListNode back = null;
        while (current != null) {
            back = new ListNode(current.val, back);
            current = current.next;
        }
        while (back != null) {
            if (back.val != head.val) {
                return false;
            }
            back = back.next;
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        //关键点在于部分反转,而不是全部反转
        ListNode midNode = getMidList(head);
        ListNode revertNode = revertList(midNode.next);
        ListNode m1 = revertNode;
        ListNode h1 = head;
        boolean isPalindrome = true;
        //这时候后半部分已经反转了
        while (isPalindrome && revertNode != null) {
            if (revertNode.val != h1.val) {
                isPalindrome = false;
            }
            revertNode = revertNode.next;
            h1 = h1.next;
        }
        revertList(m1);
        return isPalindrome;
    }

    /**
     * 获取中间结点
     *
     * @param head
     * @return
     */
    public ListNode getMidList(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        //不可能出现quick==null的情况
        while (quick.next != null && quick.next.next != null) {

            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;

    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode revertList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode tempNext = null;
        while (current != null) {
            tempNext = current.next;
            //每次遍历的时候,让被遍历的结点指向上一个结点
            current.next = prev;
            prev = current;
            current = tempNext;
        }
        return prev;
    }

    /**
     * 从头到尾打印链表
     *
     * @param head
     */
    public void print(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        print(head.next);
    }

    public static void main(String[] args) {
        ListNode l12 = new ListNode(4, null);
        ListNode l11 = new ListNode(2, l12);
        ListNode l10 = new ListNode(1, l11);

        ListNode l24 = new ListNode(5, null);
        ListNode l23 = new ListNode(4, l24);
        ListNode l22 = new ListNode(3, l23);
        ListNode l21 = new ListNode(2, l22);
        ListNode l20 = new ListNode(1, l21);
        //l20 = new MsSolution0206().revertList(l20);

        boolean result = new MsSolution0206().isPalindrome(l20);
        System.out.println(result);
        new MsSolution0206().print(l20);
    }
}
