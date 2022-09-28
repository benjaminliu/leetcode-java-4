package com.ben.array;

import java.util.stream.IntStream;

public class _0724_Find_Pivot_Index {

    class Solution {
        public int pivotIndex(int[] nums) {
            int sum = IntStream.of(nums).sum();
            if (sum == 0) {
                return 0;
            }

            int left = 0;
            int right = 0;
            for (int i = 0; i < nums.length; i++) {
                right = sum - left - nums[i];
                if (left == right) {
                    return i;
                }
                left += nums[i];
            }

            return -1;
        }
    }
}
