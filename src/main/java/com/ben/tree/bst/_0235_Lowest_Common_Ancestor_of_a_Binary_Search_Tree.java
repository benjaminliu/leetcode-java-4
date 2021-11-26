package com.ben.tree.bst;

import com.ben.common.TreeNode;

public class _0235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        if (root.val > p.val && root.val < q.val) {
            return root;
        }

        if (root.val < p.val && root.val > q.val) {
            return root;
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return lowestCommonAncestor(root.right, p, q);
    }
}
