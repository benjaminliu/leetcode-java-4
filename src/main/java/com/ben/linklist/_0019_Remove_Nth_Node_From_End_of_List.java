package com.ben.linklist;

import com.ben.common.ListNode;
import com.ben.util.ListNodeUtil;
import com.ben.util.PrintUtil;

public class _0019_Remove_Nth_Node_From_End_of_List {
    public static void main(String[] args) {
//        ListNode head = ListNodeUtil.create(1, 2, 3, 4, 5);
        ListNode head = ListNodeUtil.create(1,2);
//        ListNode head = ListNodeUtil.create(1);

        PrintUtil.printListNode(removeNthFromEnd(head, 1));
    }

    static public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = new ListNode(-1);

        fast.next = head;

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        ListNode slow = new ListNode(-1);
        slow.next = head;

        ListNode dummy = slow;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}
