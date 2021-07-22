package com.ly.leetcode;

public class JzSolution52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = revert(headA);
        ListNode currentA=tempA;
        ListNode tempB = revert(headB);
        ListNode currentB=tempB;
        ListNode prev = null;
        while (currentA != null && currentB != null) {
            if (currentA  != currentB ) {
                break;
            }
            prev = currentA;
            currentA = currentA.next;
            currentB = currentB.next;
        }
        headA=revert(tempA);
        headB=revert(tempB);
        return prev;
    }

    private ListNode revert(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode temp;
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l12 = new ListNode(4, null);
        ListNode l11 = new ListNode(6, l12);
        ListNode l10 = new ListNode(1, l11);

        ListNode l23 = new ListNode(4, null);
        ListNode l22 = new ListNode(6, l23);
        ListNode l21 = new ListNode(3, l22);
        ListNode l20 = new ListNode(1, l21);

        ListNode node = new JzSolution52().getIntersectionNode(l10, l20);
        while (l10!=null){
            System.out.printf("%3s",l10.val);
            l10=l10.next;
        }
        while (l20!=null){
            System.out.printf("%3s",l20.val);
            l20=l20.next;
        }
        System.out.println(node.val);
    }
}
