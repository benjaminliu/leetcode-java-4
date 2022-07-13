package com.ben.backtracking;

import com.ben.util.PrintUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _0139_m_Word_Break {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");

        PrintUtil.printLn(new Solution().wordBreak(s, wordDict));
    }

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int[] memo = new int[s.length()];
            Set<String> set = new HashSet<>(wordDict);
            return backTracking(s, 0, set, memo);
        }

        private boolean backTracking(String s, int startIdx, Set<String> set, int[] memo) {
            if (startIdx == s.length()) {
                return true;
            }
            if (memo[startIdx] == -1) {
                return false;
            }

            for (int endIdx = startIdx + 1; endIdx <= s.length(); endIdx++) {
                String sub = s.substring(startIdx, endIdx);
                if (!set.contains(sub)) {
                    continue;
                }

                if (backTracking(s, endIdx, set, memo)) {
                    return true;
                }
            }

            memo[startIdx] = -1;
            return false;
        }
    }
}
