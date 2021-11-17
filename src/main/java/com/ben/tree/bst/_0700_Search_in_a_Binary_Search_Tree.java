package com.ben.tree.bst;

import com.ben.common.TreeNode;

public class _0700_Search_in_a_Binary_Search_Tree {

    static public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        }

        return searchBST(root.right, val);
    }

}
