package com.ben.backtracking;

import java.util.*;

public class _0040_m_Combination_Sum_II {

    class Solution {

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> res = new ArrayList<>();
            helper(candidates, 0, target, new ArrayList<Integer>(), res);
            return res;
        }

        private void helper(int[] candidates, int start, int target, ArrayList<Integer> group, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(group));
                return;
            }

            if (target < 0) {
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    break;
                }
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                group.add(candidates[i]);
                helper(candidates, i + 1, target - candidates[i], group, res);
                group.remove(group.size() - 1);
            }
        }
    }
}
