package com.ben.tree.bst;

import com.ben.common.TreeNode;
import com.ben.util.TreeUtil;

public class _0701_Insert_into_a_Binary_Search_Tree {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTree(40, 20, 60, 10, 30, 50, 70, null, null, 25, null, 25, null, 25);

        insertIntoBST(root, 25);
    }

    static public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        helper(root, val);
        return root;
    }

    public static void helper(TreeNode root, int val) {
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return;
            }

            helper(root.left, val);
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            }

            helper(root.right, val);
        }
    }


    TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            root.right = insertIntoBST1(root.right, val);
        } else {
            root.left = insertIntoBST1(root.left, val);
        }
        return root;
    }
}
