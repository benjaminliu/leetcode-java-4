package com.ben.util;

import com.ben.common.ListNode;

import java.util.List;

public class PrintUtil {

    private static final String link_seperator = " -> ";

    private static final String list_seperator = ", ";

    public static void printArray(int[] array) {
        if (array == null) {
            System.out.println("Array is null");
            return;
        }

        if (array.length == 0) {
            System.out.println("Array is empty");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0, last = array.length - 1; i < array.length; i++) {
            sb.append(array[i]);
            if (i < last) {
                sb.append(list_seperator);
            }
        }

        System.out.println(sb.toString());
    }

    public static void printList(List<?> list) {
        if (list == null) {
            System.out.println("List is null");
            return;
        }

        if (list.size() == 0) {
            System.out.println("List is empty");
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0, last = list.size() - 1; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < last) {
                sb.append(list_seperator);
            }
        }

        System.out.println(sb.toString());
    }

    public static void printListOfList(List<List<Integer>> groups) {
        if (groups == null) {
            System.out.println("List is null");
            return;
        }

        if (groups.size() == 0) {
            System.out.println("List is empty");
            return;
        }


        for (List<Integer> list : groups) {
            if (list == null)
                continue;

            printList(list);
        }
    }

    public static void printListNode(ListNode node) {
        if (node != null) {
            StringBuilder sb = new StringBuilder();
            do {
                sb.append(node.val);
                if (node.next != null) {
                    sb.append(link_seperator);
                }
                node = node.next;
            } while (node != null);
            System.out.println(sb.toString());
        } else {
            System.out.println("List is null");
        }
    }

    public static void printOneListNode(ListNode node) {
        if (node != null) {
            System.out.println(node.val);
        } else {
            System.out.println("List is null");
        }
    }
}
