package com.ben.linklist.reverse;

import com.ben.common.ListNode;
import com.ben.util.ListNodeUtil;
import com.ben.util.PrintUtil;

public class Reverse_first_n_node_in_linked_list {
    public static void main(String[] args) {
//        ListNode head = ListNodeUtil.create(1, 2, 3, 4, 5);
        ListNode head = ListNodeUtil.create(1, 2, 3, 4, 5, 6);
//        ListNode head = ListNodeUtil.create(1, 2);

        PrintUtil.printListNode(reverseN(head, 3));
    }

    static ListNode successor = null;

    /**
     * Recursive
     */
    static public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode next = head.next;
        ListNode newHead = reverseN(next, n - 1);
        next.next = head;
        head.next = successor;

        return newHead;
    }

    /**
     * Iteration
     */
    static public ListNode reverseN_1(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        if (n < 2) {
            return head;
        }


        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;

        ListNode firstNode = cur;
        int idx = 1;
        while (idx < n) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
            idx++;
        }

        cur.next = pre;

        firstNode.next = next;

        return cur;
    }


}
