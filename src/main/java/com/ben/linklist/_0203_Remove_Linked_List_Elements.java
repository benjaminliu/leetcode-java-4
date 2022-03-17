package com.ben.linklist;

import com.ben.common.ListNode;
import com.ben.util.PrintUtil;

public class _0203_Remove_Linked_List_Elements {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        PrintUtil.printListNode(new Solution().removeElements(head, 6));
    }

    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode(-1);

            dummy.next = head;

            ListNode cur = dummy;

            while (cur.next != null) {
                if (cur.next.val == val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }

            return dummy.next;
        }
    }
}
