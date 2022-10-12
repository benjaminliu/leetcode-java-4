package com.ben.dp;

public class _0647_m_Palindromic_Substrings {

    class Solution {
        public int countSubstrings(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];

            for (int right = 0; right < s.length(); right++) {
                for (int left = 0; left <= right; left++) {
                    if (s.charAt(right) == s.charAt(left)) {
                        // one letter is palindromic
                        // two letter, because s.charAt(i) == s.charAt(j), is also palindromic
                        if (right - left < 3) {
                            dp[left][right] = true;
                        } else {
                            //remove left letter and right letter, to see if it is palindromic
                            //such as  "abccba",  remove left and right letter, become "bccb"
                            dp[left][right] = dp[left + 1][right - 1];
                        }
                    }
                }
            }

            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    if (dp[i][j]) {
                        res++;
                    }
                }
            }
            return res;
        }
    }
}
