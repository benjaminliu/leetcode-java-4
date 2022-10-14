package com.ben.dp;

public class _0673_m_Number_of_Longest_Increasing_Subsequence {

    class Solution {
        public int findNumberOfLIS(int[] nums) {
            if (nums.length == 1) {
                return 1;
            }

            //length of longest increasing subsequence
            int[] lisLen = new int[nums.length];
            //count of longest increasing subsequence
            int[] count = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                lisLen[i] = 1;
                count[i] = 1;
            }

            int maxLen = 0;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        //nums[i] > nums[j]
                        //so the LIS length will increase 1
                        int newLISLen = lisLen[j] + 1;

                        if (newLISLen > lisLen[i]) {
                            lisLen[i] = newLISLen;

                            // newLISLen bigger than old LIS length at i
                            // update the LIS's count at i to at j
                            count[i] = count[j];
                        } else if (newLISLen == lisLen[i]) {
                            // newLISLen equals old LIS length at i
                            // add up LIS's count at i to both i and j
                            count[i] += count[j];
                        }
                    }
                    maxLen = Math.max(maxLen, lisLen[i]);
                }
            }

            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (maxLen == lisLen[i]) {
                    res += count[i];
                }
            }
            return res;
        }
    }
}
