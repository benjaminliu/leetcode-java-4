package com.ben.array;

import com.ben.util.PrintUtil;

public class _0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2};
        int target = 2;

        PrintUtil.printArray(new Solution().searchRange(nums, target));
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int start = findStart(nums, target, 0, nums.length - 1);
            if (start == -1) {
                return new int[]{-1, -1};
            }

            int end = findEnd(nums, target, start, nums.length - 1);
            return new int[]{start, end};
        }

        private int findEnd(int[] nums, int target, int left, int right) {
            while (left <= right) {
                int mid = (left + right) / 2;
                int midVal = nums[mid];

                if (midVal == target) {
                    if (mid == right) {
                        return mid;
                    } else if (nums[mid + 1] > target) {
                        return mid;
                    }
                    left = mid + 1;
                } else if (midVal > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return nums.length - 1;
        }

        private int findStart(int[] nums, int target, int left, int right) {
            while (left <= right) {
                int mid = (left + right) / 2;
                int midVal = nums[mid];
                if (midVal == target) {
                    if (mid == left) {
                        return mid;
                    } else if (nums[mid - 1] < target) {
                        return mid;
                    }

                    right = mid - 1;
                } else if (midVal > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
}
