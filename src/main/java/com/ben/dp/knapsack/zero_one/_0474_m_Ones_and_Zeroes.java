package com.ben.dp.knapsack.zero_one;

public class _0474_m_Ones_and_Zeroes {
    class Solution {
        //We can think the knapsack has 2 pocket,
        // one for 0s, weight is m,
        // the other noe for 1s, weight is n
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 0; i < strs.length; i++) {
                int ones = 0;
                int zeros = 0;

                for (char c : strs[i].toCharArray()) {
                    if (c == '0') {
                        zeros++;
                    } else {
                        ones++;
                    }
                }

                for (int j = m; j >= zeros; j--) {
                    for (int k = n; k >= ones; k--) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                    }
                }
            }

            return dp[m][n];
        }
    }
}
