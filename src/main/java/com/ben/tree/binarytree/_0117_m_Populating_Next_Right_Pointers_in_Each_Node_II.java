package com.ben.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class _0117_m_Populating_Next_Right_Pointers_in_Each_Node_II {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.right = new Node(7);

        Node newRoot = new Solution().connect(root);
    }

    static class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                Node last = null;
                while (size > 0) {
                    Node cur = queue.poll();
                    if (last != null) {
                        last.next = cur;
                    }
                    last = cur;
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                    size--;
                }
            }

            return root;
        }
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
