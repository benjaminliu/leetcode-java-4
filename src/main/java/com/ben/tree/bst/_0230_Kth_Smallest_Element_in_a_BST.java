package com.ben.tree.bst;

import com.ben.common.TreeNode;

public class _0230_Kth_Smallest_Element_in_a_BST {

    public static void main(String[] args) {

    }

    private static int val;
    private static int rank;
    private static boolean found;

    static public int kthSmallest(TreeNode root, int k) {
        rank = 0;
        found = false;
        traverse(root, k);

        return val;
    }

    static private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        traverse(root.left, k);
        if (found) {
            return;
        }
        rank++;
        if (rank == k) {
            val = root.val;
            found = true;
            return;
        }

        traverse(root.right, k);
    }
}
