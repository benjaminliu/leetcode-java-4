package com.ben.tree.binarytree;

import com.ben.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0114_Flatten_Binary_Tree_to_Linked_List {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        new Solution1().flatten(root);
    }

    public static class Solution1 {
        static public void flatten(TreeNode root) {
            flatten(root, null);
        }

        /**
         * Need more care
         *
         * @param root
         * @param firstNode
         * @return
         */
        static public TreeNode flatten(TreeNode root, TreeNode firstNode) {
            if (root == null) {
                return firstNode;
            }

            //Flatten right branch, return firstNode
            firstNode = flatten(root.right, firstNode);
            //Flatten left branch, and add right branch to the end of left branch, and return firstNode
            firstNode = flatten(root.left, firstNode);

            //Add the firstNode to the root's right node
            root.right = firstNode;
            root.left = null;

            return root;
        }
    }

    public static class Solution2 {
        static public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }

            flatten(root.left);
            flatten(root.right);

            TreeNode left = root.left;
            TreeNode right = root.right;

            root.left = null;
            root.right = left;

            TreeNode cur = root;
            while (cur.right != null) {
                cur = cur.right;
            }

            cur.right = right;
        }
    }

    public static class Solution3 {
        static public void flatten(TreeNode root) {
            List<TreeNode> allNode = new ArrayList<>();
            addNode(root, allNode);

            for (int i = 1; i < allNode.size(); i++) {
                TreeNode pre = allNode.get(i - 1);
                TreeNode cur = allNode.get(i);
                pre.left = null;
                pre.right = cur;
            }
        }

        static public void addNode(TreeNode root, List<TreeNode> allNode) {
            if (root == null) {
                return;
            }
            allNode.add(root);

            if (root.left != null) {
                addNode(root.left, allNode);
            }
            if (root.right != null) {
                addNode(root.right, allNode);
            }
        }
    }
}
