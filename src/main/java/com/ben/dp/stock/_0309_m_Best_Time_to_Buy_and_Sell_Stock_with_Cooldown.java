package com.ben.dp.stock;

import com.ben.util.PrintUtil;

public class _0309_m_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};

        PrintUtil.printLn(new Solution().maxProfit(prices));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 1) {
                return 0;
            }

            int[][] dp = new int[prices.length][2];
            //[i][0] means cost
            //[i][1] means profit
            dp[0][0] = prices[0];
            dp[0][1] = 0;

            dp[1][0] = Math.min(prices[0], prices[1]);
            dp[1][1] = Math.max(0, prices[1] - prices[0]);

            for (int i = 2; i < prices.length; i++) {
                dp[i][0] = Math.min(dp[i - 1][0], prices[i] - dp[i - 2][1]);
                dp[i][1] = Math.max(dp[i - 1][1], prices[i] - dp[i][0]);
            }

            return dp[prices.length - 1][1];
        }
    }
}
