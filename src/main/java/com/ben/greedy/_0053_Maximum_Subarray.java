package com.ben.greedy;

import com.ben.util.PrintUtil;

public class _0053_Maximum_Subarray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, -1};
        PrintUtil.printLn(new Solution().maxSubArray(nums));
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }

            int max = Integer.MIN_VALUE;
            int sum = 0;

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];

                if (sum > max) {
                    max = sum;
                }

                if (sum < 0) {
                    sum = 0;
                }
            }

            return max;
        }
    }
}
