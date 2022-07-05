package com.ben.dp.knapsack.zero_one;

import java.util.stream.IntStream;

public class _1049_m_Last_Stone_Weight_II {

    class Solution {
        public int lastStoneWeightII(int[] stones) {
            int sum = IntStream.of(stones).sum();

            int target = sum / 2;

            int[] dp = new int[target + 1];

            for (int i = 0; i < stones.length; i++) {
                for (int j = target; j >= stones[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                }
            }

            // sum - dp[target] is the larger half,   dp[target] is the smaller half
            return (sum - dp[target]) - dp[target];
        }
    }
}
