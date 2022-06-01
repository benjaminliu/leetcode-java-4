package com.ben.greedy;

public class _0122_m_Best_Time_to_Buy_and_Sell_Stock_II {

    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            int last = prices[0];
            for (int i = 1; i < prices.length; i++) {

                if (prices[i] > last) {
                    profit += prices[i] - last;
                }
                last = prices[i];
            }

            return profit;
        }
    }
}
