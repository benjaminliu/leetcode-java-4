package com.ben.tree.bst;

import com.ben.common.TreeNode;

public class _0108_Convert_Sorted_Array_to_Binary_Search_Tree {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }

        private TreeNode helper(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }

            if (start == end) {
                return new TreeNode(nums[start]);
            }

            int mid = (start + end) / 2;

            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, start, mid - 1);
            root.right = helper(nums, mid + 1, end);
            return root;
        }
    }
}
