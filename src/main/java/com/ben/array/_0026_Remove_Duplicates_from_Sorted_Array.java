package com.ben.array;

public class _0026_Remove_Duplicates_from_Sorted_Array {

    class Solution {
        public int removeDuplicates(int[] nums) {
            int duplication = 0;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    duplication++;
                } else {
                    nums[i - duplication] = nums[i];
                }
            }

            return nums.length - duplication;
        }
    }
}
