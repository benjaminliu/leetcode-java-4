package com.ben.array;

import com.ben.util.PrintUtil;

public class _0209_Minimum_Size_Subarray_Sum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};

        PrintUtil.printLn(new Solution().minSubArrayLen(11, nums));
    }

    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int left = 0;
            int right = 0;

            int sum = nums[0];
            int minLen = Integer.MAX_VALUE;

            while (true) {
                if (sum >= target) {
                    int newLen = right - left + 1;
                    if (newLen < minLen) {
                        minLen = newLen;
                    }

                    sum -= nums[left];
                    left++;
                } else {
                    right++;

                    if (right == nums.length) {
                        break;
                    }

                    sum += nums[right];
                }
            }

            if (minLen == Integer.MAX_VALUE) {
                return 0;
            }

            return minLen;
        }
    }


    static class Solution2 {
        public int minSubArrayLen(int target, int[] nums) {
            int sum = 0;
            int start = 0;
            int minLen = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                while (sum >= target) {
                    int len = i - start + 1;
                    if (len < minLen) {
                        minLen = len;
                        if (minLen == 1) {
                            return 1;
                        }
                    }

                    sum -= nums[start];
                    start++;
                }
            }

            if (minLen == Integer.MAX_VALUE) {
                return 0;
            }

            return minLen;
        }
    }
}
