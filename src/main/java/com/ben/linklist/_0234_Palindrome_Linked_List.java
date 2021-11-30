package com.ben.linklist;

import com.ben.common.ListNode;
import com.ben.util.ListNodeUtil;

public class _0234_Palindrome_Linked_List {
    public static void main(String[] args) {
//        ListNode head = ListNodeUtil.create(1, 2, 2, 1);
//        ListNode head = ListNodeUtil.create(1, 2, 3, 2, 1);
//        ListNode head = ListNodeUtil.create(1, 1);
        ListNode head = ListNodeUtil.create(1);
//        ListNode head = ListNodeUtil.create(1, 2);
        System.out.println(new Solution1().isPalindrome(head));
    }

    public static class Solution1 {
        // left is move from the first node to mid node
        static ListNode left;

        static public boolean isPalindrome(ListNode head) {
            left = head;
            return traverse(head);
        }

        // from right to left, compare with left node
        static boolean traverse(ListNode right) {
            if (right == null) {
                return true;
            }

            //if any node is not equal, return false
            //Compare right node first
            if (!traverse(right.next)) {
                return false;
            }

            //then compare current node
            boolean curNodeEquals = left.val == right.val;

            //Move left to next node
            left = left.next;
            return curNodeEquals;
        }
    }

    public static class Solution2 {
        static public boolean isPalindrome(ListNode head) {
            if (head.next == null) {
                return true;
            }

            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            ListNode rightHalfHead;
            //Even node
            if (fast == null) {
                rightHalfHead = slow;
            } else {
                //Odd node
                rightHalfHead = slow.next;
            }

            //We split the linked list into 2 linked list.
            // when the length is even, like 8,  we split into 4 + 4,
            // when the length is odd,  like 9, we split into 5 + 4, the left has 1 more node.
            // but when we compare these 2 linked list,  we use the length of right linked list,
            // so the extra node will be ignored
            ListNode rightCur = reverse(rightHalfHead);
            ListNode leftCur = head;
            while (rightCur != null) {
                if (rightCur.val != leftCur.val) {
                    return false;
                }
                rightCur = rightCur.next;
                leftCur = leftCur.next;
            }
            return true;
        }

        static public ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode pre = null;
            ListNode cur = head;
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
