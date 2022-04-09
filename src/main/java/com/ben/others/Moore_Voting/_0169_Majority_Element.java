package com.ben.others.Moore_Voting;

public class _0169_Majority_Element {

    class Solution {
        public int majorityElement(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }

            int n = nums[0];
            int nCount = 1;

            for (int i = 1; i < nums.length; i++) {
                if (n == nums[i]) {
                    nCount++;
                } else if (nCount == 0) {
                    n = nums[i];
                    nCount = 1;
                } else {
                    nCount--;
                }
            }

            return n;
        }
    }
}
