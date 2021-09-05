package com.ben.linklist;

import com.ben.common.ListNode;
import com.ben.util.ListNodeUtil;
import com.ben.util.PrintUtil;

public class _0876_Middle_of_the_Linked_List {
    public static void main(String[] args) {
        ListNode head = ListNodeUtil.create(1, 2, 3, 4, 5);
//        ListNode head = ListNodeUtil.create(1, 2, 3, 4, 5, 6);

        PrintUtil.printListNode(middleNode(head));
    }

    static public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
