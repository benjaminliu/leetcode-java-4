package com.ben.linklist;

import com.ben.common.ListNode;
import com.ben.util.ListUtil;
import com.ben.util.PrintUtil;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _0023_Merge_k_Sorted_Lists {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = ListUtil.create(1, 4, 5);
        lists[1] = ListUtil.create(1, 3, 4);
        lists[2] = ListUtil.create(2, 6);

        ListNode res = mergeKLists(lists);

        PrintUtil.printListNode(res);
    }

    static public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for (ListNode ln : lists) {
            if (ln != null) {
                minHeap.add(ln);
            }
        }

        if (minHeap.size() == 0) {
            return null;
        }

        ListNode head = minHeap.poll();
        ListNode cur = head;

        do {
            if (cur.next != null) {
                minHeap.add(cur.next);
            }

            cur.next = minHeap.poll();
            cur = cur.next;
        } while (minHeap.size() > 0);

        return head;
    }
}
