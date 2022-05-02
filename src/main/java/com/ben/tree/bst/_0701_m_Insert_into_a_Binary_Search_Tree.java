package com.ben.tree.bst;

import com.ben.common.TreeNode;

public class _0701_m_Insert_into_a_Binary_Search_Tree {

    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }

            if (root.val > val) {
                root.left = insertIntoBST(root.left, val);
            } else {
                root.right = insertIntoBST(root.right, val);
            }
            return root;
        }
    }
}
