package com.ben.tree.binarytree;

import com.ben.common.TreeNode;

public class _0111_Minimum_Depth_of_Binary_Tree {

    class Solution {
        public int minDepth(TreeNode root) {

            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }

            if (root.left == null) {
                return minDepth(root.right) + 1;
            }

            if (root.right == null) {
                return minDepth(root.left) + 1;
            }

            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

        }
    }
}
