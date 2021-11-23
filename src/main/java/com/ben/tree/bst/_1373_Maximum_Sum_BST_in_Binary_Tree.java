package com.ben.tree.bst;

import com.ben.common.TreeNode;
import com.ben.util.TreeUtil;

public class _1373_Maximum_Sum_BST_in_Binary_Tree {

    public static void main(String[] args) {
//        TreeNode root = TreeUtil.createTree(1, 4, 3, 2, 4, 2, 5, null, null, null, null, null, null, 4, 6);
//        TreeNode root = TreeUtil.createTree(4, 3, null, 1, 2);
        TreeNode root = TreeUtil.createTree(5, 4, 8, 3, null, 6, 3);
        System.out.println(maxSumBST(root));
    }

    private static int maxSum;

    private static class Result {
        boolean isBST;
        int min;
        int max;
        int sum;
    }

    static public int maxSumBST(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxSum = 0;
        traverse(root);
        return maxSum;
    }

    private static Result traverse(TreeNode root) {
        Result res = new Result();

        // Null node
        if (root == null) {
            res.isBST = true;
            res.min = Integer.MAX_VALUE;
            res.max = Integer.MIN_VALUE;
            res.sum = 0;
            return res;
        }

        // Leaf node
        if (root.left == null && root.right == null) {
            res.isBST = true;
            res.min = root.val;
            res.max = root.val;
            res.sum = root.val;

            if (root.val > maxSum) {
                maxSum = root.val;
            }

            return res;
        }

        Result left = traverse(root.left);
        Result right = traverse(root.right);

        // Branch node
        if (left.isBST == true && right.isBST == true
                && left.max < root.val && right.min > root.val) {

            res.isBST = true;
            res.min = Math.min(left.min, root.val);
            res.max = Math.max(right.max, root.val);
            res.sum = root.val + left.sum + right.sum;

            if (res.sum > maxSum) {
                maxSum = res.sum;
            }
            return res;
        }

        res.isBST = false;
        return res;
    }


}
