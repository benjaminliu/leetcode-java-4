package com.ben.array;

import com.ben.util.PrintUtil;

public class _0035_Search_Insert_Position {

    public static void main(String[] args) {
        PrintUtil.printLn(new Solution().searchInsert(new int[]{1, 3}, 2));
    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            if (target < nums[left]) {
                return 0;
            }
            if (target > nums[right]) {
                return nums.length;
            }

            while (left <= right) {
                int mid = (left + right) / 2;
                int midVal = nums[mid];

                if (midVal == target) {
                    return mid;
                }

                if (midVal > target) {
                    if (mid >= left + 1) {
                        if (nums[mid - 1] < target) {
                            return mid;
                        }
                    }

                    right = mid - 1;
                } else {
                    if (mid <= right - 1) {
                        if (nums[mid + 1] > target) {
                            return mid + 1;
                        }
                    }
                    left = mid + 1;
                }
            }

            return -1;
        }
    }
}
