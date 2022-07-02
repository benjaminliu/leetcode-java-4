package com.ben.dp.pack;

import com.ben.util.PrintUtil;

import java.util.stream.IntStream;

public class _0416_m_Partition_Equal_Subset_Sum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};

        PrintUtil.printLn(new Solution().canPartition(nums));
    }

    static class Solution {
        public boolean canPartition(int[] nums) {
            int sum = IntStream.of(nums).sum();
            if (sum % 2 != 0) {
                return false;
            }

            int halfSum = sum / 2;

            int[] dp = new int[halfSum + 1];

            for (int i = 0; i < nums.length; i++) {
                for (int j = halfSum; j >= nums[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);

                    PrintUtil.printArray(dp);
                }
                if (dp[halfSum] == halfSum) {
                    return true;
                }
            }

            return false;
        }
    }
}
