package com.ben.greedy;

import com.ben.util.PrintUtil;

public class _0376_m_Wiggle_Subsequence {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 2, 3, 2, 3
        };

        PrintUtil.printLn(new Solution().wiggleMaxLength(nums));

        PrintUtil.printLn(new Solution2().wiggleMaxLength(nums));
    }

    static class Solution {
        public int wiggleMaxLength(int[] nums) {
            int count = 1;


            for (int i = 1; i < nums.length; ) {
                if (nums[i] == nums[i - 1]) {
                    i++;
                    continue;
                }
                count++;

                int tmp = i + 1;
                if (nums[i] > nums[i - 1]) {
                    //go up
                    while (tmp < nums.length && nums[tmp] >= nums[tmp - 1]) {
                        tmp++;
                    }

                } else {
                    //go down
                    while (tmp < nums.length && nums[tmp] <= nums[tmp - 1]) {
                        tmp++;
                    }
                }
                i = tmp;
            }
            return count;
        }
    }

    static class Solution2 {
        public int wiggleMaxLength(int[] nums) {
            int curDiff = 0;
            int preDiff = 0;

            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                curDiff = nums[i] - nums[i - 1];

                //if curDiff == 0, will not enter if
                //Change direction
                if ((curDiff > 0 && preDiff <= 0)
                        || (curDiff < 0 && preDiff >= 0)) {
                    count++;
                    preDiff = curDiff;
                }
            }
            return count;
        }
    }
}
