package com.ben.dp.knapsack.unbounded;

public class _0518_m_Coin_Change_2 {

    class Solution {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int i = 0; i < coins.length; i++) {
                for (int j = coins[i]; j <= amount; j++) {

                    //      taken + not taken
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }

            return dp[amount];
        }
    }
}
