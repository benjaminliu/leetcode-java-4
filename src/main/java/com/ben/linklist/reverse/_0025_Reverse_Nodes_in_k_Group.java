package com.ben.linklist.reverse;

import com.ben.common.ListNode;
import com.ben.util.ListNodeUtil;
import com.ben.util.PrintUtil;

public class _0025_Reverse_Nodes_in_k_Group {
    public static void main(String[] args) {
        ListNode head = ListNodeUtil.create(1, 2, 3, 4, 5);

        PrintUtil.printListNode(reverseKGroup(head, 3));
    }

    static public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode start = head;
        ListNode end = head;

        for (int i = 0; i < k; i++) {
            //No enough node(less then k), no need to reverse
            if (end == null) {
                return head;
            }
            end = end.next;
        }

        ListNode newHead = reverse(start, end);
        //After reverse,  start changed to end,   end changed to start
        start.next = reverseKGroup(end, k);
        return newHead;
    }

    static public ListNode reverse(ListNode start, ListNode end) {
        ListNode pre = null;
        ListNode cur = start;
        ListNode next;

        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }


//    static public ListNode reverseKGroup(ListNode head, int k) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode cur = head;
//        ListNode preTail = null;
//
//        while (cur != null) {
//            successor = null;
//
//            ListNode curHead = reverseN(cur, k);
//            if (preTail == null) {
//                head = curHead;
//            } else {
//                preTail.next = curHead;
//            }
//            preTail = cur;
//            cur = cur.next;
//        }
//
//        return head;
//    }
//
//    static ListNode successor = null;
//
//    static public ListNode reverseN(ListNode head, int n) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        if (n == 1) {
//            successor = head.next;
//            return head;
//        }
//
//        ListNode next = head.next;
//        ListNode newHead = reverseN(next, n - 1);
//        next.next = head;
//
//        head.next = successor;
//
//        return newHead;
//    }
}
