package com.ben.tree.binarytree;

import com.ben.common.TreeNode;

public class _0112_Path_Sum {

    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }

            if (root.left == null && root.right == null) {
                if (targetSum == root.val) {
                    return true;
                }
                return false;
            }
            targetSum -= root.val;

            if (root.left != null) {
                if (hasPathSum(root.left, targetSum)) {
                    return true;
                }
            }

            if (root.right != null) {
                if (hasPathSum(root.right, targetSum)) {
                    return true;
                }
            }

            return false;
        }
    }
}
