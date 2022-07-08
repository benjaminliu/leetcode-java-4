package com.ben.dp.knapsack.unbounded;

import com.ben.util.PrintUtil;

public class _0070_m_Climbing_Stairs {

    public static void main(String[] args) {
        PrintUtil.printLn(new Solution().climbStairs(2));
    }

    static class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];

            int[] steps = new int[]{1, 2};
            dp[0] = 1;

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j < steps.length; j++) {
                    if (i >= steps[j]) {
                        dp[i] = dp[i] + dp[i - steps[j]];
                    }
                }
            }

            return dp[n];
        }
    }
}
