package com.ben.others.Moore_Voting;

import com.ben.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _0229_m_Majority_Element_II {
    public static void main(String[] args) {
        PrintUtil.printList(new Solution().majorityElement(new int[]{6, 5, 5}));
    }

    static class Solution {
        public List<Integer> majorityElement(int[] nums) {
            if (nums.length < 3) {
                return IntStream.of(nums).boxed().distinct().collect(Collectors.toList());
            }

            //The initial value does not matters, just notice that  first != second
            int first = 0;
            int second = 1;

            int firstCount = 0;
            int secondCount = 0;

            for (int i = 0; i < nums.length; i++) {
                if (first == nums[i]) {
                    firstCount++;
                } else if (second == nums[i]) {
                    secondCount++;
                } else if (firstCount == 0) {
                    first = nums[i];
                    firstCount = 1;
                } else if (secondCount == 0) {
                    second = nums[i];
                    secondCount = 1;
                } else {
                    firstCount--;
                    secondCount--;
                }
            }

            firstCount = 0;
            secondCount = 0;
            for (int i : nums) {
                if (i == first) {
                    firstCount++;
                } else if (i == second) {
                    secondCount++;
                }
            }

            List<Integer> res = new ArrayList<>(2);
            if (firstCount > nums.length / 3) {
                res.add(first);
            }
            if (secondCount > nums.length / 3) {
                res.add(second);
            }

            return res;
        }
    }
}
