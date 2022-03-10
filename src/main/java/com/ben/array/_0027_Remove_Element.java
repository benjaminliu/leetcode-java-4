package com.ben.array;

public class _0027_Remove_Element {


    class Solution {
        public int removeElement(int[] nums, int val) {
            int targetCount = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    targetCount++;
                } else {
                    nums[i - targetCount] = nums[i];
                }
            }

            return nums.length - targetCount;
        }
    }
}
