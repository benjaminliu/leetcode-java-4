package com.ben.linklist;

import com.ben.common.ListNode;
import com.ben.util.ListNodeUtil;

public class _0141_Linked_List_Cycle {

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.create(3, 2, 0, -4);

        System.out.println(hasCycle(head));
    }

    static public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
