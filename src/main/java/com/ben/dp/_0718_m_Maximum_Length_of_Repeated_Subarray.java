package com.ben.dp;

import com.ben.util.PrintUtil;

public class _0718_m_Maximum_Length_of_Repeated_Subarray {

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1, 2, 3, 2, 1};
//        int[] nums2 = new int[]{3, 2, 1, 4, 7};

        int[] nums1 = new int[]{1, 2, 3, 2, 8};
        int[] nums2 = new int[]{5, 6, 1, 4, 7};

        PrintUtil.printLn(new Solution().findLength(nums1, nums2));
    }

    static class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int[][] dp = new int[nums1.length][nums2.length];

            int max = 0;

            for (int row = 0; row < nums1.length; row++) {
                if (nums1[row] == nums2[0]) {
                    dp[row][0] = 1;
                    max = 1;
                }
            }

            for (int col = 0; col < nums2.length; col++) {
                if (nums1[0] == nums2[col]) {
                    dp[0][col] = 1;
                    max = 1;
                }
            }
            for (int i = 1; i < nums1.length; i++) {
                for (int j = 1; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }

            return max;
        }
    }
}
