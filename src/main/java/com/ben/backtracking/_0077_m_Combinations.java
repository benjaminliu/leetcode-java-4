package com.ben.backtracking;

import com.ben.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class _0077_m_Combinations {
    public static void main(String[] args) {
        PrintUtil.printListOfList(new Solution().combine(4, 2));
    }

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();

            helper(n, k, 0, new ArrayList<Integer>(), res);
            return res;
        }

        private void helper(int n, int k, int start, ArrayList<Integer> group, List<List<Integer>> res) {
            if (k == 0) {
                res.add(new ArrayList<>(group));
                return;
            }

            for (int i = start; i < n; i++) {
                group.add(i + 1);

                helper(n, k - 1, i + 1, group, res);

                group.remove(group.size() - 1);
            }
        }
    }
}
