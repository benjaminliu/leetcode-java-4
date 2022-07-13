package com.ben.dp.knapsack.unbounded;

import java.util.List;

public class _0139_m_Word_Break {

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDict.contains(s.substring(j, i))) {
                        dp[i] = true;
                    }
                }
            }
            return dp[s.length()];
        }
    }
}
