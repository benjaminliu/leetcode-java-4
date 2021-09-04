package com.ben.linklist;

import com.ben.common.ListNode;
import com.ben.common.ListUtil;
import com.ben.common.PrintUtil;

public class _0021_Merge_Two_Sorted_Lists {

    public static void main(String[] args) {

//        ListNode l1 = ListUtil.createList(1, 2, 4);
//        ListNode l2 = ListUtil.createList(1, 3, 4);

        ListNode l1 = ListUtil.createList(2);
        ListNode l2 = ListUtil.createList(1);

        ListNode res = mergeTwoLists(l1, l2);

        PrintUtil.printListNode(res);
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

        ListNode result;
        if (c1.val <= c2.val) {
            result = c1;
            c1 = c1.next;
        } else {
            result = c2;
            c2 = c2.next;
        }

        ListNode cur = result;

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

        return result;
    }
}
