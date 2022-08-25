package com.ben.dp;

import java.util.stream.IntStream;

public class _0053_m_Maximum_Subarray {

    class Solution {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            }

            return IntStream.of(dp).max().getAsInt();
        }
    }
}
