package com.ben.tree.bst;

import com.ben.common.TreeNode;

public class _0450_Delete_Node_in_a_BST {


    static public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            //Get the min value of right subtree, and then delete the min node
            int min = getMin(root.right);
            root.val = min;

            root.right = deleteNode(root.right, min);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private static int getMin(TreeNode cur) {
        while (cur.left != null) {
            cur = cur.left;
        }

        return cur.val;
    }
}
