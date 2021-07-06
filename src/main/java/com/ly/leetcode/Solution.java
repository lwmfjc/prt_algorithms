
package com.ly.leetcode;
public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode next1 = l1;
        ListNode next2 = l2;
        long sum1 = 0;
        int index1 = 0;

        long sum2 = 0;
        int index2 = 0;
        while (next1 != null) {
            sum1 += (next1.val * Math.pow(10, index1));
            next1 = next1.next;
            index1++;
        }
        while (next2 != null) {
            sum2 += (next2.val * Math.pow(10, index2));
            next2 = next2.next;
            index2++;
        }

        //首元素
        ListNode head;

        if ((sum1 + sum2) / 10 == 0) {
            head = new ListNode((int)(sum1 + sum2) , null);

        } else {

            long sum = sum1 + sum2;

            head = new ListNode((int)(sum % 10), null);

            sum = sum / 10;

            ListNode last = head;
            while (true) {
                ListNode nodeNew = new ListNode((int)(sum % 10), null);
                last.next = nodeNew;
                last = nodeNew;
                if (sum / 10 == 0) {
                    break;
                }
                sum = sum / 10;
            }

        }
        return head;
    }

}