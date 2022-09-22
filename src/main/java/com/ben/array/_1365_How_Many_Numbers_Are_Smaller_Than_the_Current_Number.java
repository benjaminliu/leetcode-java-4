package com.ben.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number {

    class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] copy = Arrays.copyOf(nums, nums.length);
            Arrays.sort(copy);
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && copy[i] == copy[i - 1]) {
                    continue;
                }

                map.put(copy[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                copy[i] = map.get(nums[i]);
            }
            return copy;
        }
    }
}
