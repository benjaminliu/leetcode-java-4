package com.ben.dp.stock;

public class _0121_Best_Time_to_Buy_and_Sell_Stock {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 1) {
                return 0;
            }

            int low = prices[0];
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                int cur = prices[i];
                if (cur < low) {
                    low = cur;
                } else if (cur > low) {
                    int profit = cur - low;
                    maxProfit = Math.max(maxProfit, profit);
                }
            }

            return maxProfit;
        }
    }

    class Solution1 {
        public int maxProfit(int[] prices) {
            if (prices.length == 1) {
                return 0;
            }

            int len = prices.length;

            int[][] dp = new int[len][2];
            //[i][0] means on the ith day, what's the lowest price
            dp[0][0] = prices[0];
            //[i][1] means on the ith day, what's the max profit
            dp[0][1] = 0;

            int res = 0;

            for (int i = 1; i < len; i++) {
                //hold yesterday's stock,  or buy today's stock, which is lower
                dp[i][0] = Math.min(dp[i - 1][0], prices[i]);

                //yesterday's profit,  or today's profit, which is bigger
                dp[i][1] = Math.max(dp[i - 1][1], prices[i] - dp[i - 1][0]);
            }

            return dp[len - 1][1];
        }
    }
}
