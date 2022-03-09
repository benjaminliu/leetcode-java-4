package com.ben.array;

public class _0704_Binary_Search {

    class Solution {
        public int search(int[] nums, int target) {
            return help(nums, target, 0, nums.length - 1);
        }

        private int help(int[] nums, int target, int left, int right) {
            if (left > right) {
                return -1;
            }
            int mid = (left + right) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                return mid;
            }

            if (midVal > target) {
                return help(nums, target, left, right - 1);
            }

            return help(nums, target, left + 1, right);
        }
    }

    class Solution2 {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                int midVal = nums[mid];

                if (midVal == target) {
                    return mid;
                }
                if (midVal > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return -1;
        }
    }

}
