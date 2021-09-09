package com.ben.tree;

import java.util.ArrayList;
import java.util.List;

public class _0116_Populating_Next_Right_Pointers_in_Each_Node {


    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node newRoot = connect(root);

        System.out.println();
    }

    static public Node connect(Node root) {
        Node levelStart = root;
        while (levelStart != null && levelStart.left != null) {
            Node cur = levelStart;
            while (cur != null) {
                cur.left.next = cur.right;

                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }

        return root;
    }

    static public Node connect_2(Node root) {
        if (root == null) {
            return null;
        }

        connectTwoNode(root.left, root.right);
        return root;
    }

    static public void connectTwoNode(Node left, Node right) {
        if (left == null) {
            return;
        }

        left.next = right;

        connectTwoNode(left.left, left.right);
        connectTwoNode(left.right, right.left);
        connectTwoNode(right.left, right.right);
    }


    static public Node connect_1(Node root) {
        if (root == null) {
            return null;
        }

        traverse(root, 0, new ArrayList<>());

        return root;
    }

    /**
     * @param root
     * @param level
     * @param levelNode store the the last node of each level
     */
    static public void traverse(Node root, int level, List<Node> levelNode) {
        if (root.left == null) {
            return;
        }

        root.left.next = root.right;

        //First node in current level
        if (levelNode.size() <= level) {
            levelNode.add(root.right);
        } else {
            Node pre = levelNode.get(level);
            pre.next = root.left;
            levelNode.set(level, root.right);
        }

        traverse(root.left, level + 1, levelNode);
        traverse(root.right, level + 1, levelNode);
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
