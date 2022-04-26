package com.ben.tree.binarytree;

import com.ben.common.TreeNode;

public class _0617_Merge_Two_Binary_Trees {

    class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return null;
            }

            TreeNode newRoot;
            if (root1 != null && root2 != null) {
                newRoot = new TreeNode(root1.val + root2.val);
            } else if (root1 == null) {
                newRoot = new TreeNode(root2.val);
            } else {
                newRoot = new TreeNode(root1.val);
            }


            TreeNode left1 = root1 == null ? null : root1.left;
            TreeNode left2 = root2 == null ? null : root2.left;

            TreeNode right1 = root1 == null ? null : root1.right;
            TreeNode right2 = root2 == null ? null : root2.right;

            newRoot.left = mergeTrees(left1, left2);
            newRoot.right = mergeTrees(right1, right2);

            return newRoot;
        }
    }
}
