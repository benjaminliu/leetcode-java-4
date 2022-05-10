package com.ben.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _0039_m_Combination_Sum {

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            helper(candidates, 0, new ArrayList<Integer>(), target, res);
            return res;
        }

        private void helper(int[] candidates, int start, ArrayList<Integer> group, int target, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(group));
                return;
            }
            if (target < 0) {
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                group.add(candidates[i]);
                helper(candidates, i, group, target - candidates[i], res);
                group.remove(group.size() - 1);
            }
        }
    }
}
