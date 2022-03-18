package com.ben.linklist.reverse;

import com.ben.common.ListNode;
import com.ben.util.ListNodeUtil;
import com.ben.util.PrintUtil;

public class _0206_Reverse_Linked_List {
    public static void main(String[] args) {
        ListNode head = ListNodeUtil.create(1, 2, 3, 4, 5);
//        ListNode head = ListNodeUtil.create(1, 2);

        PrintUtil.printListNode(new Solution4().reverseList(head));
    }

    public static class Solution1 {
        /**
         * Recursive
         */
        static public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode next = head.next;
            ListNode newHead = reverseList(next);
            //After reverse sub-list, node next become the last node of new list
            //so next should point to current node (during reverse sub-list, we clean next.next pointer)
            next.next = head;

            //clean next pointer
            head.next = null;
            return newHead;
        }
    }

    public static class Solution2 {
        /**
         * Recursive,  insert
         */
        static public ListNode reverseList(ListNode head) {
            return reverseList(head, null);
        }

        static public ListNode reverseList(ListNode head, ListNode newHead) {
            if (head == null) {
                return newHead;
            }
            ListNode next = head.next;
            head.next = newHead;
            return reverseList(next, head);
        }
    }

    public static class Solution3 {
        /**
         * Iteration
         */
        static public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode next;
            ListNode cur = head;
            ListNode pre = null;

            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }


    static class Solution4 {
        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode pre = null;
            ListNode next;

            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            return pre;
        }
    }
}
