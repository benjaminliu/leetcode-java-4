package com.ben.tree.binarytree;

import com.ben.common.TreeNode;
import com.ben.util.TreeUtil;

public class _0226_Invert_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTree(4, 2, 7, 1, 3, 6, 9);

        TreeNode newRoot = invertTree(root);

        System.out.println();
    }

    static public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
