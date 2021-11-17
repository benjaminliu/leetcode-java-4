package com.ben.tree;

import com.ben.common.TreeNode;

import java.util.LinkedList;

public class _0297_Serialize_and_Deserialize_Binary_Tree {
    public static void main(String[] args) {

    }

    static class PreOrder {
        String SEP = ",";
        String NULL = "#";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            traverse(root, sb);
            return sb.toString();
        }

        public void traverse(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }

            sb.append(root.val).append(SEP);
            traverse(root.left, sb);
            traverse(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> nodes = new LinkedList<>();
            for (String s : data.split(SEP)) {
                nodes.addLast(s);
            }

            return deTraverse(nodes);
        }

        public TreeNode deTraverse(LinkedList<String> nodes) {
            if (nodes.isEmpty()) {
                return null;
            }

            String first = nodes.removeFirst();
            if (NULL.equals(first)) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(first));

            root.left = deTraverse(nodes);
            root.right = deTraverse(nodes);

            return root;
        }
    }

//    static class InOrder {
//        // Encodes a tree to a single string.
//        public String serialize(TreeNode root) {
//
//        }
//
//
//        // Decodes your encoded data to tree.
//        public TreeNode deserialize(String data) {
//
//        }
//    }
//
//    static class PostOrder {
//        // Encodes a tree to a single string.
//        public String serialize(TreeNode root) {
//
//        }
//
//
//        // Decodes your encoded data to tree.
//        public TreeNode deserialize(String data) {
//
//        }
//    }
}
