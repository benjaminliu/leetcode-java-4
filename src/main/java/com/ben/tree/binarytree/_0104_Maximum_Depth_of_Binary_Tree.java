package com.ben.tree.binarytree;

import com.ben.common.TreeNode;

public class _0104_Maximum_Depth_of_Binary_Tree {

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
