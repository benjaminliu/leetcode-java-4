package com.ben.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _0078_m_Subsets {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            helper(nums, 0, new ArrayList<Integer>(), res);
            return res;
        }

        private void helper(int[] nums, int start, ArrayList<Integer> group, List<List<Integer>> res) {
            res.add(new ArrayList<>(group));

            if (start == nums.length) {
                return;
            }

            for (int i = start; i < nums.length; i++) {
                group.add(nums[i]);
                helper(nums, i + 1, group, res);
                group.remove(group.size() - 1);
            }
        }
    }
}
