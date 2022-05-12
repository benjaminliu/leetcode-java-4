package com.ben.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0090_m_Subsets_II {

    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
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
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                group.add(nums[i]);
                helper(nums, i + 1, group, res);
                group.remove(group.size() - 1);
            }
        }
    }
}
