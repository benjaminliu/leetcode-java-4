package com.ben.backtracking;

import com.ben.util.PrintUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0491_Increasing_Subsequences {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 7, 7};
        PrintUtil.printListOfList(new Solution().findSubsequences(nums));
    }

    static class Solution {
        private Set<String> set;

        public List<List<Integer>> findSubsequences(int[] nums) {
            set = new HashSet<>();
            List<List<Integer>> res = new ArrayList<>();
            helper(nums, 0, new ArrayList<Integer>(), res);
            return res;
        }

        private void helper(int[] nums, int start, ArrayList<Integer> group, List<List<Integer>> res) {
            if (group.size() > 1 && set.add(generateKey(group))) {
                res.add(new ArrayList<>(group));
            }

            for (int i = start; i < nums.length; i++) {
                if (group.size() > 0 && nums[i] < group.get(group.size() - 1)) {
                    continue;
                }

                group.add(nums[i]);
                helper(nums, i + 1, group, res);
                group.remove(group.size() - 1);
            }
        }

        private String generateKey(ArrayList<Integer> group) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : group) {
                sb.append(i).append("-");
            }
            return sb.toString();
        }
    }

    static class Solution2 {

        public List<List<Integer>> findSubsequences(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            helper(nums, 0, new ArrayList<Integer>(), res);
            return res;
        }

        private void helper(int[] nums, int start, ArrayList<Integer> group, List<List<Integer>> res) {
            if (group.size() > 1) {
                res.add(new ArrayList<>(group));
            }

            Set<Integer> used = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                if (used.contains(nums[i])) {
                    continue;
                }

                if (group.size() == 0 || nums[i] >= group.get(group.size() - 1)) {
                    used.add(nums[i]);
                    group.add(nums[i]);
                    helper(nums, i + 1, group, res);
                    group.remove(group.size() - 1);
                }
            }
        }
    }
}