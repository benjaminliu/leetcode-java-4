package com.ben.tree.binarytree;

import com.ben.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0257_Binary_Tree_Paths {

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            helper(root, res, new StringBuilder());
            return res;
        }

        private void helper(TreeNode root, List<String> res, StringBuilder sb) {
            int len = sb.length();
            sb.append(root.val);

            if (root.left == null && root.right == null) {
                //Leaf
                res.add(sb.toString());
            } else {
                sb.append("->");

                if (root.left != null) {
                    helper(root.left, res, sb);
                }

                if (root.right != null) {
                    helper(root.right, res, sb);
                }
            }

            //restore
            sb.setLength(len);
        }
    }
}
