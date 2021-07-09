package com.ly.leetcode;

/**
 * todo 先放着,头疼不想做了
 */
public class Solution23 {
    public class ListNode {
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

    public ListNode mergeKLists(ListNode[] lists) {
        int N = lists.length;
        ListNode[] heads = new ListNode[N];

        ListNode[] headsTemp = new ListNode[N];

        //将所有链表首节点放到heads数组中
        for (int i = 0; i < N; i++) {
            heads[i] = lists[i];
        }
        ListNode listNode = null;
        while (true) {
            //一开始的时候把值复制到临时表中
            for (int i = 0; i < N; i++) {
                if (headsTemp[i] != null) {
                    headsTemp[i] = new ListNode();
                } else {
                    headsTemp[i] = null;
                }
            }


            for (int i = 0; i < N; i++) {
                if (heads[i] != null) {
                    heads[i] = heads[i].next;
                }
            }

        }
    }
}
