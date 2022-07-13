package com.ben.dp.knapsack.unbounded;

public class _0279_m_Perfect_Squares {

    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];

            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                dp[i] = Integer.MAX_VALUE;
            }

            for (int i = 0; i <= n; i++) {
                int square = i * i;
                if (square > n) {
                    break;
                }
                for (int j = square; j <= n; j++) {
                    if (dp[j - square] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j - square] + 1);
                    }
                }
            }

            return dp[n];
        }
    }
}
