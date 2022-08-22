package com.ben.dp;

import com.ben.util.PrintUtil;

public class _1143_m_Longest_Common_Subsequence {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        PrintUtil.printLn(new Solution().longestCommonSubsequence(text1, text2));
    }

    static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int row = text1.length();
            int col = text2.length();

            char[] chars1 = text1.toCharArray();
            char[] chars2 = text2.toCharArray();

            int[][] dp = new int[row + 1][col + 1];
            dp[0][0] = 0;

            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    if (chars1[i - 1] == chars2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }

                PrintUtil.printArrayOfArray(dp);
            }

            return dp[row][col];
        }
    }
}
