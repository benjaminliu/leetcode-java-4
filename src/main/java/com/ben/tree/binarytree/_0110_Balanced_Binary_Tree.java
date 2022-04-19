package com.ben.tree.binarytree;

import com.ben.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _0110_Balanced_Binary_Tree {

    class Solution {
        public boolean isBalanced(TreeNode root) {
            return helper(root, new HashMap<>());
        }

        private boolean helper(TreeNode root, Map<TreeNode, Integer> map) {
            if (root == null) {
                return true;
            }

            int leftDepth = depth(root.left, map);
            int rightDepth = depth(root.right, map);

            if (Math.abs(leftDepth - rightDepth) > 1) {
                return false;
            }

            if (!helper(root.left, map)) {
                return false;
            }

            if (!helper(root.right, map)) {
                return false;
            }

            return true;
        }

        private int depth(TreeNode root, Map<TreeNode, Integer> map) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            Integer d = map.get(root);
            if (d != null) {
                return d;
            }

            int leftDepth = depth(root.left, map);
            int rightDepth = depth(root.right, map);

            int depth = Math.max(leftDepth, rightDepth) + 1;
            map.put(root, depth);
            return depth;
        }
    }
}
