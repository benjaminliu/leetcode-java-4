package com.ben.others.sumulator;

import com.ben.util.PrintUtil;

import java.util.Arrays;

public class _0031_m_Next_Permutation {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1};

        new Solution().nextPermutation(nums);
        PrintUtil.printArray(nums);
    }

    static class Solution {
        public void nextPermutation(int[] nums) {

            for (int i = nums.length - 1; i > 0; i--) {

                if (nums[i] > nums[i - 1]) {
                    int minIdx = finMinBiggerIdx(nums, i, nums.length, nums[i - 1]);
                    swap(nums, i - 1, minIdx);

                    Arrays.sort(nums, i, nums.length);
                    return;
                }
            }

            Arrays.sort(nums);
        }

        private int finMinBiggerIdx(int[] nums, int start, int end, int v) {
            int minBigger = start;
            for (int i = start + 1; i < end; i++) {
                if (nums[i] > v) {
                    if (nums[i] < nums[minBigger]) {
                        minBigger = i;
                    }
                }
            }
            return minBigger;
        }

        private void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
}
