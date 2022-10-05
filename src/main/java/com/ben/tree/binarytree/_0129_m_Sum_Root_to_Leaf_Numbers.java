package com.ben.tree.binarytree;

import com.ben.common.TreeNode;
import com.ben.util.PrintUtil;

public class _0129_m_Sum_Root_to_Leaf_Numbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        PrintUtil.printLn(new Solution().sumNumbers(root));
    }

    static class Solution {
        public int sumNumbers(TreeNode root) {
            return help(root, 0);
        }

        private int help(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            int temp = sum * 10 + root.val;

            if (root.left == null && root.right == null) {
                return temp;
            }

            int left = help(root.left, temp);
            int right = help(root.right, temp);
            return left + right;
        }
    }
}
