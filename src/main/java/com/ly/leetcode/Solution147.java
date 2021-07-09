package com.ly.leetcode;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode point = head.next;//要插入的链表结点,从第二个结点开始
        ListNode tempPointNext = null;

        while (point != null) {//直到最后一个要插入的元素
            tempPointNext = point.next;

            ListNode current = head; //从第一个元素开始遍历
            ListNode last = null; //上一个遍历的结点
            ListNode tempPointNext1 = null;
            boolean find = false;

            while (current != point) { //开始遍历
                //如果已经找到过就不做比较了
                if (!find && current.val > point.val) {//比要插入的元素大
                    if (last == null) {
                        head = point;
                    }else {
                        last.next=point;
                    }
                    find = true;
                    tempPointNext1 = point.next;
                    point.next = current;
                }

                last = current;
                current = current.next;
            }
            //如果找到了元素
            if (find) {
                last.next = tempPointNext1;
            }

            point = tempPointNext;

        }
        return head;
    }

    public static void main(String[] args) {
        //4->2->1->3
        ListNode node4 = new ListNode(3, null);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(4, node2);
        ListNode head=new Solution147().insertionSortList(node1);

        ListNode current = head;
        while (current != null) {
            System.out.printf("%3d", current.val);
            current = current.next;
        }

    }
}
