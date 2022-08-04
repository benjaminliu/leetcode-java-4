package com.ben.dp;

import com.ben.common.TreeNode;

public class _0337_m_House_Robber_III {

    class Solution {
        public int rob(TreeNode root) {
            int[] res = helper(root);

            return Math.max(res[0], res[1]);
        }

        //return value is a array
        // [0] means do not rob root
        // [1] means rob root
        private int[] helper(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }

            int[] left = helper(root.left);
            int[] right = helper(root.right);

            //rob root, so we cannot rob root's child
            int robRoot = root.val + left[0] + right[0];

            //do not rob root, so we can rob root's child, or not
            int notRobRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

            return new int[]{notRobRoot, robRoot};
        }
    }
}
