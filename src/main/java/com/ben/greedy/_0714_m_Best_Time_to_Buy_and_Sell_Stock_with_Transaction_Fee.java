package com.ben.greedy;

import com.ben.util.PrintUtil;

public class _0714_m_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
    public static void main(String[] args) {

//        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
//        int fee = 2;

        int[] prices = new int[]{1, 3, 7, 5, 10, 3};
        int fee = 3;
        PrintUtil.printLn(new Solution().maxProfit(prices, fee));
    }

    static class Solution {
        public int maxProfit(int[] prices, int fee) {
            int buy = prices[0];
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                int p = prices[i];
                if (p < buy) {
                    //lower price
                    buy = p;
                } else if (p > buy + fee) {
                    maxProfit += p - buy - fee;

                    // like 1, 5, 10,   fee is 1.
                    // We should buy at 1 and sell at 10.
                    // But here, we buy at 1, sell at 5, and buy at 5 and sell at 10.
                    // So we sell twice, and we pay twice fee.
                    // Inorder no to pay fee twice, we reduce the fee for now.
                    buy = p - fee;
                }
            }

            return maxProfit;
        }


    }
}
