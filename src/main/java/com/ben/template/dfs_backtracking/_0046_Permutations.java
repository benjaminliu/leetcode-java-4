package com.ben.template.dfs_backtracking;

import com.ben.util.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _0046_Permutations {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};

        PrintUtil.printListOfList(new Solution1().permute(nums));

    }

    public static class Solution1 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            ArrayList<Integer> numList = new ArrayList<>(nums.length);
            for (int i : nums) {
                numList.add(i);
            }

            backTracking(numList, res, new LinkedList<Integer>());

            return res;
        }

        private void backTracking(ArrayList<Integer> numList, List<List<Integer>> res, LinkedList<Integer> tmp) {
            if (numList.size() == 0) {
                res.add(new ArrayList<>(tmp));
                return;
            }

            for (int i = 0; i < numList.size(); i++) {
                int number = numList.get(i);
                tmp.addLast(number);

                numList.remove(i);
                backTracking(numList, res, tmp);
                numList.add(i, number);
                tmp.removeLast();
            }
        }
    }


    public static class Solution2 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backTracking(nums, 0, res);
            return res;
        }

        private void backTracking(int[] nums, int startIndex, List<List<Integer>> res) {
            if (startIndex == nums.length) {
                List<Integer> tmp = new ArrayList<>(startIndex);
                for (int i = 0; i < startIndex; i++) {
                    tmp.add(nums[i]);
                }
                res.add(tmp);
            }

            for (int i = startIndex; i < nums.length; i++) {
                swap(nums, startIndex, i);
                backTracking(nums, startIndex + 1, res);
                swap(nums, i, startIndex);
            }
        }

        private void swap(int[] nums, int idxA, int idxB) {
            int temp = nums[idxA];
            nums[idxA] = nums[idxB];
            nums[idxB] = temp;
        }
    }
}
