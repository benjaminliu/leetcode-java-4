package com.ben.dp.knapsack.zero_one;

import java.util.stream.IntStream;

public class _0494_m_Target_Sum {

    //https://leetcode.com/problems/target-sum/discuss/455024/DP-IS-EASY!-5-Steps-to-Think-Through-DP-Questions.

    //https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C%2B%2B-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = IntStream.of(nums).sum();
            //target could be sum of all the numbers flagged with -
            if (Math.abs(target) > sum) {
                return 0;
            }

            //positiveSum, sum of the nums flagged with +
            //negativeSum, sum of the nums flagged with - (the value is still positive)
            // sum = positiveSum + negativeSum
            // so, negativeSum = sum - positiveSum
            // positiveSum - negativeSum = target
            // so, positiveSum - (sum - positiveSum) = target
            // then positiveSum - sum + positiveSum = target
            // then 2 * positiveSum - sum = target
            // then 2 * positiveSum = target + sum
            // then
            int doublePositiveSum = target + sum;
            if (doublePositiveSum % 2 == 1) {
                return 0;
            }
            int positiveSum = doublePositiveSum / 2;

            return subsetSum(nums, positiveSum);
        }

        //Choose a subset from nums, and their sum equals to positiveSum
        private int subsetSum(int[] nums, int positiveSum) {
            int[] dp = new int[positiveSum + 1];
            dp[0] = 1;

            for (int i = 0; i < nums.length; i++) {
                for (int j = positiveSum; j >= nums[i]; j--) {

                    //for those who find it hard to understand dp[i] = dp[i] + dp[i - n]

                    //let's start with int[][] dp = new int[nums.length][s + 1]
                    // where dp is 2-d array with dp[i][j] means number of ways to get sum j with first i elements from nums.

                    //Then you have the transition dp[i][j] = dp[i-1][j] + dp[i][j-nums[i]],
                    // i.e. you can get the sum j either by
                    // not taken num[i], so wo have dp[i-1][j]
                    // or
                    // taken nums[i],  we need to construct (j - nums[i]), so we have dp[i][j-nums[i]]
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }

            return dp[positiveSum];
        }
    }
}
