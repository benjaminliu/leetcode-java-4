package com.ben.linklist.reverse;

import com.ben.common.ListNode;

public class _0024_m_Swap_Nodes_in_Pairs {

    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode next;
            ListNode left;
            ListNode right;

            ListNode cur = head;
            ListNode pre = head;

            boolean first = true;

            while (cur != null && cur.next != null) {
                next = cur.next.next;

                left = cur;
                right = cur.next;

                pre.next = right;
                right.next = left;
                left.next = next;

                cur = next;
                pre = left;

                if (first) {
                    head = right;
                    first = false;
                }
            }

            return head;
        }
    }

    class Solution2 {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            //Swap head and head.next
            //So head is left,  head.next is right
            //we will swap left and right

            ListNode right = head.next;

            ListNode next = swapPairs(head.next.next);

            right.next = head;
            head.next = next;

            return right;
        }
    }
}
