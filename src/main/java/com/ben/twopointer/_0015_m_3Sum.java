package com.ben.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0015_m_3Sum {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) {
                return new ArrayList<>();
            }

            Arrays.sort(nums);

            List<List<Integer>> res = new ArrayList<>();

            for (int i = 0, end = nums.length - 2; i < end; i++) {
                //remove duplication
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int target = -nums[i];

                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    //remove duplication
                    if (left > i + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }

                    int sum = nums[left] + nums[right];
                    if (sum == target) {
                        res.add(List.of(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

            return res;
        }
    }
}
