package com.ben.dp.palidrome;

public class _0005_m_Longest_Palindromic_Substring {

    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() < 2) {
                return s;
            }

            int maxLen = 0;
            int leftIdx = 0;
            int rightIdx = 0;

            boolean[][] dp = new boolean[s.length()][s.length()];

            for (int left = s.length() - 1; left >= 0; left--) {
                for (int right = left; right < s.length(); right++) {
                    if (s.charAt(left) == s.charAt(right)) {
                        if (right - left <= 1) {
                            // one letter is palindromic
                            // two letter, because s.charAt(i) == s.charAt(j), is also palindromic
                            dp[left][right] = true;
                        } else if (dp[left + 1][right - 1]) {
                            //remove left letter and right letter, to see if it is palindromic
                            //such as  "abccba",  remove left and right letter, become "bccb"
                            dp[left][right] = true;
                        }
                    }

                    if (dp[left][right]) {
                        int len = right - left + 1;
                        if (len > maxLen) {
                            maxLen = len;
                            leftIdx = left;
                            rightIdx = right;
                        }
                    }
                }
            }

            return s.substring(leftIdx, rightIdx + 1);
        }
    }
}
