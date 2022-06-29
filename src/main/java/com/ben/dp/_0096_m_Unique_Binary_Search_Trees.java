package com.ben.dp;

import com.ben.util.PrintUtil;

public class _0096_m_Unique_Binary_Search_Trees {

    public static void main(String[] args) {
        PrintUtil.printLn(new Solution().numTrees(3));
    }

    static class Solution {
        private static int[] dp = new int[20];

        private static int maxN = 1;

        static {
            dp[0] = 1;
            dp[1] = 1;
        }

        public int numTrees(int n) {
            if (n <= maxN) {
                return dp[n];
            }

            for (int i = maxN + 1; i <= n; i++) {
                int product = 0;
                for (int j = 0; j < i; j++) {
                    int left = j - 0;
                    int right = i - j - 1;
                    product += dp[left] * dp[right];
                }

                dp[i] = product;
            }

            maxN = n;
            return dp[n];
        }
    }
}
