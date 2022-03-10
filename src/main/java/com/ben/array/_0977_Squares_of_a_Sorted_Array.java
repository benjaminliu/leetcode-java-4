package com.ben.array;

import com.ben.util.PrintUtil;

public class _0977_Squares_of_a_Sorted_Array {

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        PrintUtil.printArray(new Solution().sortedSquares(nums));
    }

    static class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] res = new int[nums.length];

            if (nums[0] >= 0) {
                //All positive start with zero
                for (int i = 0; i < nums.length; i++) {
                    int temp = nums[i];
                    res[i] = temp * temp;
                }
            } else if (nums[nums.length - 1] <= 0) {
                //All negative end with zero
                for (int i = 0; i < nums.length; i++) {
                    int temp = nums[nums.length - i - 1];
                    res[i] = temp * temp;
                }
            } else {
                // has both positive and negative


                // find 0 or first positive number
                int firstNonNagitiveIdx = 0;
                while (firstNonNagitiveIdx < nums.length) {
                    if (nums[firstNonNagitiveIdx] >= 0) {
                        break;
                    }
                    firstNonNagitiveIdx++;
                }
                int idx = 0;
                int right;
                if (nums[firstNonNagitiveIdx] == 0) {
                    res[0] = 0;
                    idx++;
                    right = firstNonNagitiveIdx + 1;
                } else {
                    right = firstNonNagitiveIdx;
                }

                //left means negative
                //right means positive

                int left = firstNonNagitiveIdx - 1;
                while (left >= 0 && right < nums.length) {
                    int tempLeft = nums[left] * -1;
                    int tempRight = nums[right];
                    if (tempLeft <= tempRight) {
                        res[idx] = tempLeft * tempLeft;
                        left--;
                    } else {
                        res[idx] = tempRight * tempRight;
                        right++;
                    }
                    idx++;
                }

                while (left >= 0) {
                    res[idx] = nums[left] * nums[left];
                    idx++;
                    left--;
                }

                while (right < nums.length) {
                    res[idx] = nums[right] * nums[right];
                    idx++;
                    right++;
                }
            }

            return res;
        }
    }


    static class Solution2 {
        public int[] sortedSquares(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            int[] res = new int[nums.length];

            for (int i = nums.length - 1; i >= 0; i--) {
                if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                    res[i] = nums[left] * nums[left];
                    left++;
                } else {
                    res[i] = nums[right] * nums[right];
                    right--;
                }
            }

            return res;
        }
    }
}
