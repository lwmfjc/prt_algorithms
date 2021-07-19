package com.ly.leetcode;

public class MsSolution0205 {

    //-------------------正题解法-------------------

    /**
     * 题目解法
     *
     * @param l1
     * @param l2
     * @param result
     * @param carry
     */
    public void addTwoNumbers(ListNode l1, ListNode l2
            , ListNode result, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return;
        }
        int num1 = 0;
        int num2 = 0;
        if (l1 != null) {
            num1 = l1.val;
        }
        if (l2 != null) {
            num2 = l2.val;
        }
        int sum = num1 + num2 + carry;
        int carry1 = sum >= 10 ? 1 : 0;

        //创建一个新的结点,添加为当前节点的下一个节点
        result.next = new ListNode(sum % 10, null);
        /*l3.next=null;*/
        addTwoNumbers(l1 != null ? l1.next : null,
                l2 != null ? l2.next : null, result.next, carry1);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        addTwoNumbers(l1, l2, listNode, 0);
        return listNode.next;
    }


    //-------------------进阶解法-------------------
    private ListNode result;

    /**
     * 进阶解法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        addTwoNumbersAdvance(l1, l2);
        return result;
    }

    public int addTwoNumbersAdvance(ListNode l1, ListNode l2) {
        if (l1 != null && l1.next == null && l2 != null && l2.next == null) {
            int num1 = l1.val;
            int num2 = l2.val;
            int sum2 = num1 + num2;
            int attach = sum2 % 10;
            result = new ListNode(attach, result);
            System.out.println(attach);
            return sum2;
        }
        int sum1 = addTwoNumbersAdvance(l1 != null ? l1.next : null, l2 != null ? l2.next : null);

        int carry = sum1 >= 10 ? 1 : 0;

        int num1 = 0;
        int num2 = 0;
        if (l1 != null) {
            num1 = l1.val;
        }
        if (l2 != null) {
            num2 = l2.val;
        }
        int sumAll = num1 + num2 + carry;
        int attach = sumAll % 10;
        System.out.println(attach);

        result = new ListNode(attach, result);
        //result = new ListNode(sumAll % 10, result.next);
        //result = new ListNode(sumAll % 10, result);
        return sumAll;
    }


    //-------------------有误的一个解法,但是结果很奇怪,所以代码保留了-------------------
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2
            , int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int num1 = 0;
        int num2 = 0;
        if (l1 != null) {
            num1 = l1.val;
        }
        if (l2 != null) {
            num2 = l2.val;
        }
        int sum = num1 + num2 + carry;
        int carry1 = sum >= 10 ? 1 : 0;
        int val = sum % 10;
        return new ListNode(val, addTwoNumbers2(l1 != null ? l1.next : null,
                l2 != null ? l2.next : null, carry1));
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return addTwoNumbers2(l1, l2, 0);
    }

    /**
     * 从头到尾打印链表
     *
     * @param head
     */
    public static void print(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.val);
        print(head.next);
    }

    public static void main(String[] args) {


        ListNode l12 = new ListNode(5, null);
        ListNode l11 = new ListNode(9, l12);
        ListNode l10 = new ListNode(2, l11);

        ListNode l24 = new ListNode(5, null);
        ListNode l23 = new ListNode(4, l24);
        ListNode l22 = new ListNode(7, null);
        ListNode l21 = new ListNode(1, l22);
        ListNode l20 = new ListNode(6, l21);

        ListNode result =
                new MsSolution0205().addTwoNumbers3(l10, l20);
        print(result);

    }

}
