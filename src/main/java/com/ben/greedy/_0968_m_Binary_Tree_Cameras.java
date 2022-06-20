package com.ben.greedy;

import com.ben.common.TreeNode;

public class _0968_m_Binary_Tree_Cameras {

    class Solution {
        private int res;

        public int minCameraCover(TreeNode root) {
            res = 0;
            if (traversal(root) == 0) {
                res++;
            }
            return res;
        }

        /**
         * return 0 means current node does not have camera coverage, and it is not a camera
         * return 1 means current node is a camera, which means it has camera coverage
         * return 2 means current node has has camera coverage, but it is not a camera
         */
        private int traversal(TreeNode root) {
            if (root == null) {
                //We think null node has camera coverage
                return 2;
            }

            int left = traversal(root.left);
            int right = traversal(root.right);

            if (left == 2 && right == 2) {
                //both children have camera coverage,
                //current node no need to be a camera (if parent is camera, current node has camera coverage)
                return 0;
            }

            if (left == 0 || right == 0) {
                //One of the children does not have camera coverage,
                // current node must be a camera, so it can cover children
                res++;
                return 1;
            }

            return 2;
        }
    }
}
