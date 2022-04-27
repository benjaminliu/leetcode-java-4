package com.ben.tree.bst;

import com.ben.common.TreeNode;

import java.util.Stack;

public class _0530_Minimum_Absolute_Difference_in_BST {

    class Solution {
        private int minDiff;
        private Integer last;

        public int getMinimumDifference(TreeNode root) {
            minDiff = Integer.MAX_VALUE;
            last = null;
            helper(root);
            return minDiff;
        }

        private void helper(TreeNode root) {
            if (root.left != null) {
                helper(root.left);
            }

            if (last == null) {
            } else {
                int diff = root.val - last;
                minDiff = Math.min(diff, minDiff);
            }

            last = root.val;

            if (root.right != null) {
                helper(root.right);
            }
        }
    }

    class Solution1 {
        public int getMinimumDifference(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;

            int minDiff = Integer.MAX_VALUE;
            Integer last = null;

            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;// left
                } else {
                    cur = stack.pop();

                    if (last != null) {  //mid
                        int diff = cur.val - last;
                        minDiff = Math.min(diff, minDiff);
                    }

                    last = cur.val;

                    cur = cur.right;  // right
                }
            }
            return minDiff;
        }
    }
}
