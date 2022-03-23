package com.ben.map_set;

import com.ben.util.PrintUtil;

import java.util.HashMap;
import java.util.Map;

public class _0001_Two_Sum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2};
        int target = 6;
        PrintUtil.printArray(new Solution().twoSum(nums, target));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i < nums.length; i++) {
                map.put(nums[i], i);
            }

            for (int i = 0, end = nums.length - 1; i < end; i++) {
                int tmp = target - nums[i];
                Integer idx = map.get(tmp);
                if (idx != null && idx != i) {
                    return new int[]{i, idx};
                }
            }

            return new int[]{-1, -1};
        }
    }

    static class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(nums[0], 0);

            for (int i = 1; i < nums.length; i++) {
                int tmp = target - nums[i];
                Integer idx = map.get(tmp);
                if (idx != null) {
                    return new int[]{idx, i};
                }
                map.put(nums[i], i);
            }

            return new int[2];
        }
    }
}
