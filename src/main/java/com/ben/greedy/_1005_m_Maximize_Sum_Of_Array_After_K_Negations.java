package com.ben.greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _1005_m_Maximize_Sum_Of_Array_After_K_Negations {

    class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                if (k > 0) {
                    if (nums[i] >= 0) {
                        k = k % 2;
                        break;
                    }
                    nums[i] = -nums[i];
                    k--;
                }
            }
            if (k == 1) {
                Arrays.sort(nums);
                nums[0] = -nums[0];
            }
            return Arrays.stream(nums).sum();
        }
    }

    class Solution2 {
        public int largestSumAfterKNegations(int[] nums, int k) {
            //Sort nums by absolute value, from big to small
            nums = IntStream.of(nums)
                    .boxed()
                    .sorted((a, b) -> Math.abs(b) - Math.abs(a))
                    .mapToInt(Integer::intValue).toArray();

            int sum = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < 0 && k > 0) {
                    //flip the negative to positive
                    nums[i] = -nums[i];
                    k--;
                }
                sum += nums[i];
            }

            if (k % 2 == 1) {
                //K is odd, so we need 1 more flip
                sum -= nums[nums.length - 1];
            } else {
                // K is even, no more flip
                sum += nums[nums.length - 1];
            }
            return sum;
        }
    }
}
