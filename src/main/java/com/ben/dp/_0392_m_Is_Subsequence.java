package com.ben.dp;

public class _0392_m_Is_Subsequence {

    class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s.length() == 0) {
                return true;
            }
            if (t.length() == 0) {
                return false;
            }

            int[] dp = new int[t.length()];

            char[] charS = s.toCharArray();
            char[] charT = t.toCharArray();


            int idx = 0;
            if (charT[0] == charS[0]) {
                dp[0] = 1;
                idx++;
            }

            for (int i = 1; i < t.length(); i++) {
                if (idx < s.length() && charT[i] == charS[idx]) {
                    idx++;
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = dp[i - 1];
                }
            }

            return dp[dp.length - 1] == s.length();
        }
    }
}
