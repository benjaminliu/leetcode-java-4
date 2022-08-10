package com.ben.dp.stock;

import com.ben.util.PrintUtil;

public class _0123_h_Best_Time_to_Buy_and_Sell_Stock_III {

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
//        int[] prices = new int[]{1, 2, 3, 4, 5};
        PrintUtil.printLn(new Solution().maxProfit(prices));
        PrintUtil.printLn(new Solution2().maxProfit(prices));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 1) {
                return 0;
            }

            int oneBuy = Integer.MAX_VALUE;
            int oneBuyOneSellProfit = 0;
            int twoBuy = Integer.MAX_VALUE;
            int twoBuyTwoSellProfit = 0;

            for (int i = 0; i < prices.length; i++) {
                int p = prices[i];

                oneBuy = Math.min(oneBuy, p);
                oneBuyOneSellProfit = Math.max(oneBuyOneSellProfit, p - oneBuy);

                twoBuy = Math.min(twoBuy, p - oneBuyOneSellProfit);
                twoBuyTwoSellProfit = Math.max(twoBuyTwoSellProfit, p - twoBuy);
            }

            return twoBuyTwoSellProfit;
        }
    }


    static class Solution2 {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            // 边界判断, 题目中 length >= 1, 所以可省去
            if (prices.length == 0) return 0;

            /*
             * 定义 5 种状态:
             * 0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
             */
            int[][] dp = new int[len][5];
            dp[0][1] = -prices[0];
            // 初始化第二次买入的状态是确保 最后结果是最多两次买卖的最大利润
            dp[0][3] = -prices[0];

            for (int i = 1; i < len; i++) {
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + prices[i]);
                dp[i][3] = Math.max(dp[i - 1][3], dp[i][2] - prices[i]);
                dp[i][4] = Math.max(dp[i - 1][4], dp[i][3] + prices[i]);
                System.out.println(dp[i][1] + ", " + dp[i][2] + ", " + dp[i][3] + ", " + dp[i][4]);
            }

            return dp[len - 1][4];
        }
    }
}
