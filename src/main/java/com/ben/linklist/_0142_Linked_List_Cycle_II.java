package com.ben.linklist;

import com.ben.common.ListNode;
import com.ben.util.ListNodeUtil;
import com.ben.util.PrintUtil;

public class _0142_Linked_List_Cycle_II {

    public static void main(String[] args) {
//        ListNode head = ListNodeUtil.create(3, 2, 0, -4);
        ListNode head = ListNodeUtil.create(1,2);
        head.next.next = head;
        PrintUtil.printOneListNode(detectCycle(head));
    }

    static public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (hasCycle == false) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
