package com.ben.dp;

import java.util.stream.IntStream;

public class _0674_Longest_Continuous_Increasing_Subsequence {

    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }

            int[] dp = new int[nums.length];
            dp[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 1;
                }
            }

            return IntStream.of(dp).max().getAsInt();
        }
    }
}
