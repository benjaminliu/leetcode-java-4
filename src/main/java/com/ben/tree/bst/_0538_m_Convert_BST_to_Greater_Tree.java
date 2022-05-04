package com.ben.tree.bst;

import com.ben.common.TreeNode;

public class _0538_m_Convert_BST_to_Greater_Tree {

    public static void main(String[] args) {

    }

    static private int sum;

    static public TreeNode convertBST(TreeNode root) {
        sum = 0;

        dfs(root);

        return root;
    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.right != null) {
            dfs(root.right);
        }

        sum += root.val;
        root.val = sum;

        if (root.left != null) {
            dfs(root.left);
        }
    }
}
