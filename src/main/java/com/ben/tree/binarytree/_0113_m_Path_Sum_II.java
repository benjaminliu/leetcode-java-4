package com.ben.tree.binarytree;

import com.ben.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0113_m_Path_Sum_II {

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            helper(root, targetSum, new ArrayList<Integer>(), res);

            return res;
        }

        private void helper(TreeNode root, int targetSum, ArrayList<Integer> group, List<List<Integer>> res) {
            if (root.left == null && root.right == null) {
                if (root.val == targetSum) {
                    group.add(root.val);
                    res.add(new ArrayList<>(group));

                    group.remove(group.size() - 1);
                }
                return;
            }

            group.add(root.val);
            targetSum -= root.val;

            if (root.left != null) {
                helper(root.left, targetSum, group, res);
            }

            if (root.right != null) {
                helper(root.right, targetSum, group, res);
            }

            group.remove(group.size() - 1);
        }
    }
}
