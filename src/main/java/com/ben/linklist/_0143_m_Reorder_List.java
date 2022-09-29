package com.ben.linklist;

import com.ben.common.ListNode;
import com.ben.util.PrintUtil;

public class _0143_m_Reorder_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        new Solution().reorderList(head);
        PrintUtil.printListNode(head);
    }

    static class Solution {
        public void reorderList(ListNode head) {

            ListNode fast = head;
            ListNode slow = head;

            if (head.next == null || head.next.next == null) {
                return;
            }

            //Split into two list
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            fast = slow.next;
            slow.next = null;

            ListNode pre = null;
            //revers second list
            while (fast.next != null) {
                ListNode next = fast.next;
                fast.next = pre;
                pre = fast;
                fast = next;
            }
            fast.next = pre;

            //merge two list
            slow = head;
            while (slow.next != null && fast.next != null) {
                ListNode nextSlow = slow.next;
                ListNode nextFast = fast.next;
                slow.next = fast;
                fast.next = nextSlow;

                slow = nextSlow;
                fast = nextFast;
            }

            if (slow.next != null) {
                ListNode nextSlow = slow.next;
                slow.next = fast;
                fast.next = nextSlow;
            } else {
                slow.next = fast;
            }
        }
    }
}
