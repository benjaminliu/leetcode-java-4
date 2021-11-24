package com.ben.tree.binarytree;

import com.ben.common.TreeNode;

public class _0654_Maximum_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});

        System.out.println();
    }

    static public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    static public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int maxIdx = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[maxIdx] < nums[i]) {
                maxIdx = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIdx]);

        root.left = constructMaximumBinaryTree(nums, start, maxIdx - 1);
        root.right = constructMaximumBinaryTree(nums, maxIdx + 1, end);

        return root;
    }
}
