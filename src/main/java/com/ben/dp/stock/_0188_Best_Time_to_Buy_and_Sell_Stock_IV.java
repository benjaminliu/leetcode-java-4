package com.ben.dp.stock;

import com.ben.util.PrintUtil;

public class _0188_Best_Time_to_Buy_and_Sell_Stock_IV {

    public static void main(String[] args) {
        int k = 2;
        int[] prices = new int[]{2, 4, 1};

        PrintUtil.printLn(new Solution().maxProfit(k, prices));
    }

    static class Solution {
        public int maxProfit(int k, int[] prices) {
            if (k == 0) {
                return 0;
            }
            if (prices.length < 2) {
                return 0;
            }

            int len = 2 * k;
            int[][] dp = new int[prices.length][len];

            for (int i = 0; i < len; i = i + 2) {
                dp[0][i] = prices[0];
            }

            for (int i = 1; i < prices.length; i++) {
                int p = prices[i];
                dp[i][0] = Math.min(dp[i - 1][0], p);

                for (int j = 1; j < len; j++) {
                    if (j % 2 == 1) {
                        //even is sell
                        dp[i][j] = Math.max(dp[i - 1][j], p - dp[i][j - 1]);
                    } else {
                        //even is buy, the new cost = price - previous sell's profit
                        dp[i][j] = Math.min(dp[i - 1][j], p - dp[i - 1][j - 1]);
                    }
                }
            }

            return dp[prices.length - 1][len - 1];
        }

        private void printRow(int[] ints) {
            for (int i = 0; i < ints.length; i++) {
                System.out.print(ints[i] + ",");
            }
            System.out.println();
        }


    }
}
