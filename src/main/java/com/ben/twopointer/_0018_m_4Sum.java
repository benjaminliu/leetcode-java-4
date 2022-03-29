package com.ben.twopointer;

import com.ben.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0018_m_4Sum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        PrintUtil.printListOfList(new Solution().fourSum(nums, target));
    }

    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);

            List<List<Integer>> res = new ArrayList<>();

            for (int i = 0, endI = nums.length - 3; i < endI; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                for (int j = i + 1, endJ = endI + 1; j < endJ; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }

                    int tmp = target - nums[i] - nums[j];

                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left < right) {

                        int sum = nums[left] + nums[right];
                        if (sum == tmp) {
                            res.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                            left++;
                            while (left < right && nums[left] == nums[left - 1]) {
                                left++;
                            }
                            right--;
                            while (left < right && nums[right] == nums[right + 1]) {
                                right--;
                            }
                        } else if (sum < tmp) {
                            left++;
                            while (left < right && nums[left] == nums[left - 1]) {
                                left++;
                            }
                        } else {
                            right--;
                            while (left < right && nums[right] == nums[right + 1]) {
                                right--;
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
}
