package com.ben.linklist;

import com.ben.common.ListNode;
import com.ben.util.ListNodeUtil;
import com.ben.util.PrintUtil;

public class _0021_Merge_Two_Sorted_Lists {

    public static void main(String[] args) {

//        ListNode l1 = ListNodeUtil.create(1, 2, 4);
//        ListNode l2 = ListNodeUtil.create(1, 3, 4);

        ListNode l1 = ListNodeUtil.create(2);
        ListNode l2 = ListNodeUtil.create(1);

        ListNode head = mergeTwoLists(l1, l2);

        PrintUtil.printListNode(head);
    }

    static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode c1 = l1;
        ListNode c2 = l2;

        ListNode head;
        if (c1.val <= c2.val) {
            head = c1;
            c1 = c1.next;
        } else {
            head = c2;
            c2 = c2.next;
        }

        ListNode cur = head;

        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                cur.next = c1;
                c1 = c1.next;
            } else {
                cur.next = c2;
                c2 = c2.next;
            }
            cur = cur.next;
        }

        if (c1 != null) {
            cur.next = c1;
        }

        if (c2 != null) {
            cur.next = c2;
        }

        return head;
    }
}
