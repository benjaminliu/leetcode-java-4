package com.ben.dp;

public class _0213_m_House_Robber_II {

    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }

            int startFrom0 = rob1(nums, 0, nums.length - 2);
            int startFrom1 = rob1(nums, 1, nums.length - 1);

            return Math.max(startFrom0, startFrom1);
        }

        private int rob1(int[] nums, int start, int end) {
            if (start == end) {
                return nums[start];
            }

            int[] dp = new int[nums.length];
            dp[start] = nums[start];
            dp[start + 1] = Math.max(dp[start], nums[start + 1]);

            for (int i = start + 2; i <= end; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }

            return dp[end];
        }
    }
}
