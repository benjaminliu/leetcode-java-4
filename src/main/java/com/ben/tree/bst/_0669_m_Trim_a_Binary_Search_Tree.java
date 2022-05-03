package com.ben.tree.bst;

import com.ben.common.TreeNode;

public class _0669_m_Trim_a_Binary_Search_Tree {

    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }

            //root is in the range
            if (root.val >= low && root.val <= high) {
                root.left = trimBST(root.left, low, high);
                root.right = trimBST(root.right, low, high);
                return root;
            }

            if (root.val < low) {
                if (root.right == null) {
                    return null;
                }

                return trimBST(root.right, low, high);
            } else {
                if (root.left == null) {
                    return null;
                }

                return trimBST(root.left, low, high);
            }
        }
    }
}
