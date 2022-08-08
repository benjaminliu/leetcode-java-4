package com.ben.dp.stock;

import com.ben.util.PrintUtil;

public class _0122_m_Best_Time_to_Buy_and_Sell_Stock_II {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        PrintUtil.printLn(new Solution3().maxProfit(prices));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 1) {
                return 0;
            }

            int low = prices[0];
            int profit = 0;

            for (int i = 1; i < prices.length; i++) {
                int price = prices[i];
                if (price > low) {
                    profit += price - low;
                }
                low = price;
            }

            return profit;
        }
    }


    static class Solution2 {
        public int maxProfit(int[] prices) {
            if (prices.length == 1) {
                return 0;
            }

            int[] dp = new int[prices.length];
            dp[0] = 0;
            int low = prices[0];

            for (int i = 1; i < prices.length; i++) {
                int price = prices[i];
                if (price > low) {
                    dp[i] = dp[i - 1] + price - low;
                } else {
                    dp[i] = dp[i - 1];
                }
                low = price;
            }
            return dp[prices.length - 1];
        }
    }


    static class Solution3 {
        public int maxProfit(int[] prices) {
            if (prices.length == 1) {
                return 0;
            }

            int[][] dp = new int[prices.length][2];

            //[][0] means low price
            dp[0][0] = prices[0];
            //[][1] means max profit
            dp[0][1] = 0;

            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = prices[i];

                //if sell(prices[i] - dp[i - 1][0]) make profit or not (0)
                dp[i][1] = dp[i - 1][1] + Math.max(0, prices[i] - dp[i - 1][0]);
            }

            return dp[prices.length - 1][1];
        }
    }
}
