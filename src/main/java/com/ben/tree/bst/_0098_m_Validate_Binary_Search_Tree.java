package com.ben.tree.bst;

import com.ben.common.TreeNode;

import java.util.Stack;

public class _0098_m_Validate_Binary_Search_Tree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2147483648);
        root.left = new TreeNode(-2147483648);

        System.out.println(new Solution().isValidBST(root));
    }

    static class Solution {

        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode root, long min, long max) {
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


    class Solution1 {
        // 递归
        private TreeNode max;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            // 左
            boolean left = isValidBST(root.left);
            if (!left) {
                return false;
            }
            // 中
            if (max != null && root.val <= max.val) {
                return false;
            }
            max = root;
            // 右
            boolean right = isValidBST(root.right);
            return right;
        }
    }

    class Solution2 {
        // 迭代
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;// 左
                }
                // 中，处理
                TreeNode pop = stack.pop();
                if (pre != null && pop.val <= pre.val) {
                    return false;
                }
                pre = pop;

                root = pop.right;// 右
            }
            return true;
        }
    }
}
