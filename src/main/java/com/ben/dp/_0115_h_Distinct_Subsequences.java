package com.ben.dp;

public class _0115_h_Distinct_Subsequences {
    class Solution {
        public int numDistinct(String s, String t) {
            int[][] dp = new int[s.length() + 1][t.length() + 1];

            //Because t "" is a subsequence of any string
            for (int i = 0; i <= s.length(); i++) {
                dp[i][0] = 1;
            }

            char[] charS = s.toCharArray();
            char[] charT = t.toCharArray();

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= t.length(); j++) {
                    if (charS[i - 1] == charT[j - 1]) {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[s.length()][t.length()];
        }
    }
}
