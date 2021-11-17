package com.ben.tree.bst;

import com.ben.common.TreeNode;

public class _0098_Validate_Binary_Search_Tree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2147483648);
        root.left = new TreeNode(-2147483648);

        System.out.println(isValidBST(root));
    }

    static public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static private boolean isValidBST(TreeNode root, long min, long max) {
        long val = root.val;
        if (val <= min || val >= max) {
            return false;
        }

        if (root.left != null) {
            if (!isValidBST(root.left, min, val)) {
                return false;
            }
        }

        if (root.right != null) {
            if (!isValidBST(root.right, val, max)) {
                return false;
            }
        }
        return true;
    }
}
