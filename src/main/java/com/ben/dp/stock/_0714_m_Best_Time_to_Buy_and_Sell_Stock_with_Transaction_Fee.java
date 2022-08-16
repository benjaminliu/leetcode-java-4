package com.ben.dp.stock;

public class _0714_m_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {

    class Solution {
        public int maxProfit(int[] prices, int fee) {
            if (prices.length == 1) {
                return 0;
            }

            int[][] dp = new int[prices.length][2];
            //cost
            dp[0][0] = prices[0];
            //profit
            dp[0][1] = 0;

            for (int i = 1; i < prices.length; i++) {
                //cost = price - profit
                dp[i][0] = Math.min(dp[i - 1][0], prices[i] - dp[i - 1][1]);
                dp[i][1] = Math.max(dp[i - 1][1], prices[i] - dp[i - 1][0] - fee);
            }

            return dp[prices.length - 1][1];
        }
    }
}
