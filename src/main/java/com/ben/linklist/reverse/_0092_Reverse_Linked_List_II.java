package com.ben.linklist.reverse;

import com.ben.common.ListNode;
import com.ben.util.ListNodeUtil;
import com.ben.util.PrintUtil;

public class _0092_Reverse_Linked_List_II {
    public static void main(String[] args) {
        ListNode head = ListNodeUtil.create(1, 2, 3, 4, 5);

        PrintUtil.printListNode(reverseBetween(head, 2, 3));
    }

    /**
     * Recursive
     */
    static public ListNode reverseBetween(ListNode head, int left, int right) {
        //Now we are at left,
        //current head is the start of the linked list,
        //we only need to reverse the first right node
        if (left == 1) {
            successor = null;
            return reverseN(head, right);
        }
        // until reach to left, we don't need to reverse
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    static ListNode successor = null;

    /**
     * reverse first n node
     */
    static public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // store the n + 1 node
            successor = head.next;
            return head;
        }

        ListNode newHead = reverseN(head.next, n - 1);

        head.next.next = head;
        // point to the n + 1 node
        head.next = successor;
        return newHead;
    }

    /**
     * Iteration
     */
    static public ListNode reverseBetween_1(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

        if (left == right) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;
        ListNode nodeBeforeLeft;
        int idx = 1;
        if (left == 0) {
            nodeBeforeLeft = dummy;
        } else {
            while (idx < left) {
                cur = cur.next;
                idx++;
            }

            nodeBeforeLeft = cur;
            cur = cur.next;
        }
        ListNode lastNodeInReverse = cur;

        ListNode pre = null;
        ListNode next = cur.next;
        while (idx < right) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
            idx++;
        }

        cur.next = pre;

        nodeBeforeLeft.next = cur;
        lastNodeInReverse.next = next;

        return dummy.next;
    }
}
