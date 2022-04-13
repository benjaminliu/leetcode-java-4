package com.ben.tree.binarytree;

import com.ben.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0637_Average_of_Levels_in_Binary_Tree {

    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {

            if (root == null) {
                return new ArrayList<>();
            }

            List<Pair> levels = new ArrayList<>();
            helper(root, levels, 0);

            List<Double> res = new ArrayList<>(levels.size());
            for (Pair p : levels) {
                res.add(p.avg());
            }
            return res;
        }

        private void helper(TreeNode root, List<Pair> levels, int idx) {
            if (idx >= levels.size()) {
                levels.add(new Pair((double) root.val));
            } else {
                Pair pair = levels.get(idx);
                pair.add(root.val);
            }

            if (root.left != null) {
                helper(root.left, levels, idx + 1);
            }
            if (root.right != null) {
                helper(root.right, levels, idx + 1);
            }
        }

        class Pair {
            private Double sum = 0.0;
            private int count = 0;

            public Pair(Double sum) {
                this.sum = sum;
                this.count = 1;
            }

            public void add(int val) {
                this.sum += val;
                this.count++;
            }

            public Double avg() {
                if (count == 0) {
                    return 0.0;
                }

                return sum / count;
            }
        }
    }
}
