package com.ben.dp;

public class _0583_m_Delete_Operation_for_Two_Strings {

    class Solution {
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 1; i <= word1.length(); i++) {
                dp[i][0] = i;
            }

            for (int i = 1; i <= word2.length(); i++) {
                dp[0][i] = i;
            }

            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        //相等，不用删
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        //dp[i - 1][j - 1] + 2   同时删word1[i - 1]和word2[j - 1]，操作的最少次数为dp[i - 1][j - 1] + 2
                        //dp[i - 1][j] + 1       删word1[i - 1]，最少操作次数为dp[i - 1][j] + 1
                        //dp[i][j - 1] + 1       删word2[j - 1]，最少操作次数为dp[i][j - 1] + 1
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + 2,
                                Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                    }
                }
            }

            return dp[word1.length()][word2.length()];
        }
    }
}
