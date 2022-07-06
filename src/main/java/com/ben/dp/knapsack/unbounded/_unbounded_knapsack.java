package com.ben.dp.knapsack.unbounded;

import com.ben.util.PrintUtil;

public class _unbounded_knapsack {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;

        PrintUtil.printLn(new Solution().unboundedKnapsack(weight, value, bagWeight));

    }

    static class Solution {

        public int unboundedKnapsack(int[] weight, int[] value, int bagWeight) {
            int[] dp = new int[bagWeight + 1];

            for (int i = 0; i < weight.length; i++) {
                for (int j = weight[i]; j <= bagWeight; j++) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }

                PrintUtil.printArray(dp);
            }

            return dp[bagWeight];
        }
    }
}
