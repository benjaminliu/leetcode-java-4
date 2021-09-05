package com.ben.linklist;

import com.ben.common.ListNode;
import com.ben.util.PrintUtil;

import java.util.HashSet;
import java.util.Set;

public class _0160_Intersection_of_Two_Linked_Lists {

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(4);

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = node2;

        ListNode headB = new ListNode(3);
        headB.next = node2;

        PrintUtil.printListNode(getIntersectionNode(headA, headB));
    }

    /**
     * https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
     * Same idea with getIntersectionNode_2, but only need a few lines.
     * <p>
     * listA.length + listB.length == listB.length + listA.length
     */
    static public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null) {
            return null;
        }

        if (headB == null) {
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = (curA == null ? headB : curA.next);  //Add listB to the end of listA
            curB = (curB == null ? headA : curB.next);  //Add listA to the end of listB
        }
        return curA;
    }


    static public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        if (headA == null) {
            return null;
        }

        if (headB == null) {
            return null;
        }

        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null && curB != null) {
            curA = curA.next;
            curB = curB.next;
        }

        if (curA == null) {
            return getIntersectionNodeInternal(headA, headB, curB);
        }

        return getIntersectionNodeInternal(headB, headA, curA);
    }

    static public ListNode getIntersectionNodeInternal(ListNode shortList, ListNode longList, ListNode longListCur) {
        ListNode longSecondRound = longList;
        while (longListCur != null) {
            longListCur = longListCur.next;
            longSecondRound = longSecondRound.next;
        }

        ListNode shortSecondRound = shortList;
        while (shortSecondRound != null) {
            if (shortSecondRound == longSecondRound) {
                return shortSecondRound;
            }

            shortSecondRound = shortSecondRound.next;
            longSecondRound = longSecondRound.next;
        }

        return null;
    }

    static public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
        if (headA == null) {
            return null;
        }

        if (headB == null) {
            return null;
        }

        Set<ListNode> set = new HashSet<>();

        ListNode cur = headA;
        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }

        cur = headB;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }
}
