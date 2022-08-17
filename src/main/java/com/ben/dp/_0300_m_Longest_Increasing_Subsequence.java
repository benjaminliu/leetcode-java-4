package com.ben.dp;

import com.ben.util.PrintUtil;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _0300_m_Longest_Increasing_Subsequence {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        PrintUtil.printLn(new Solution().lengthOfLIS(nums));
    }

    static class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 1) {
                return 1;
            }

            int[] dp = new int[nums.length];
            dp[0] = 1;

            for (int i = 1; i < nums.length; i++) {
                //find the longest subsequence that is smaller than nums[i]
                int longestLength = 0;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        longestLength = Math.max(dp[j], longestLength);
                    }
                }

                //because nums[i] is bigger than the longest subsequence,
                //we can add nums[i] at the end of the longest subsequence, so add 1 to the length
                dp[i] = longestLength + 1;
            }

            return IntStream.of(dp).max().getAsInt();
        }
    }
}
