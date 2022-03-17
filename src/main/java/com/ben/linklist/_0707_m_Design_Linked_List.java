package com.ben.linklist;

import com.ben.util.PrintUtil;

public class _0707_m_Design_Linked_List {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        myLinkedList.get(4);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(5, 0);
        myLinkedList.addAtHead(6);

    }

    public static class MyLinkedListNode {
        public int val;
        public MyLinkedListNode next;

        public MyLinkedListNode(int val) {
            this.val = val;
        }

        public MyLinkedListNode(int val, MyLinkedListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class MyLinkedList {

        private MyLinkedListNode head;
        private int size;

        public MyLinkedList() {
            head = new MyLinkedListNode(-1);
        }

        public int get(int index) {
            if (!safeToProcess(index)) {
                return -1;
            }
            if (index == size) {
                return -1;
            }
            MyLinkedListNode cur = moveToIndex(index);
            return cur.val;
        }


        public void addAtHead(int val) {
            MyLinkedListNode node = new MyLinkedListNode(val, head.next);
            head.next = node;
            size++;
        }

        public void addAtTail(int val) {
            MyLinkedListNode cur = moveToIndex(size - 1);
            cur.next = new MyLinkedListNode(val);
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (!safeToProcess(index)) {
                return;
            }
            MyLinkedListNode cur = moveToIndex(index - 1);
            cur.next = new MyLinkedListNode(val, cur.next);
            size++;
        }

        public void deleteAtIndex(int index) {
            if (!safeToProcess(index)) {
                return;
            }
            if (index == size) {
                return;
            }
            MyLinkedListNode cur = moveToIndex(index - 1);
            cur.next = cur.next.next;
            size--;
        }

        private MyLinkedListNode moveToIndex(int index) {
            MyLinkedListNode cur = head;
            while (index >= 0) {
                cur = cur.next;
                index--;
            }
            return cur;
        }

        private boolean safeToProcess(int index) {
            if (index > size) {
                return false;
            }
            return true;
        }
    }
}
