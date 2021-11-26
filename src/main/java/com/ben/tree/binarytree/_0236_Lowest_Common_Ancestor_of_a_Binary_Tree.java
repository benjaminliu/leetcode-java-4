package com.ben.tree.binarytree;

import com.ben.common.TreeNode;

public class _0236_Lowest_Common_Ancestor_of_a_Binary_Tree {

    // Use post order traverse, search from leaf to root, from bottom to top
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // for left or right,
        // if null, means either p or q is found
        // if not null, means one of p or q is found

        // both left and right are not null, means both p and q are found
        if (left != null && right != null) {
            return root;
        }

        // both left and right are null, means both p and q are not found
        if (left == null && right == null) {
            return null;
        }

        // one of left or right is not null, the other one is null
        // means one of p or q is found
        // return the found one
        return left == null ? right : left;
    }


}
