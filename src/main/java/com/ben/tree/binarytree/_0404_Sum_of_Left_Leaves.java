package com.ben.tree.binarytree;

import com.ben.common.TreeNode;

public class _0404_Sum_of_Left_Leaves {

    class Solution {
        private int sum;

        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }

            sum = 0;

            helper(root);

            return sum;
        }

        private void helper(TreeNode root) {
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) {
                    sum += root.left.val;
                } else {
                    helper(root.left);
                }
            }

            if (root.right != null) {
                helper(root.right);
            }
        }
    }
}
