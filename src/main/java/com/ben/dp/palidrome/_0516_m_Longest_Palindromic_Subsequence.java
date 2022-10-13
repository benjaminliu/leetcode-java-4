package com.ben.dp.palidrome;

public class _0516_m_Longest_Palindromic_Subsequence {

    /**
     *   c b b d
     * c 1 1 2 2
     * b 0 1 2 2
     * b 0 0 1 1
     * d 0 0 0 1
     */
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int[][] dp = new int[s.length() + 1][s.length() + 1];

            for (int i = s.length() - 1; i >= 0; i--) {
                dp[i][i] = 1;
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }

            //upper left corner
            return dp[0][s.length() - 1];
        }
    }
}
