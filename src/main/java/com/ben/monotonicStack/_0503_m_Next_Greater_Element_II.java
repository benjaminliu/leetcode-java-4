package com.ben.monotonicStack;

import com.ben.util.PrintUtil;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _0503_m_Next_Greater_Element_II {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};

        PrintUtil.printArray(new Solution().nextGreaterElements(nums));
    }

    static class Solution {
        public int[] nextGreaterElements(int[] nums) {
            if (nums.length == 1) {
                return new int[]{-1};
            }
            Deque<Integer> stack = new LinkedList<>();
            int[] res = new int[nums.length];
            Arrays.fill(res, -1);
            for (int i = 0; i < nums.length * 2; i++) {
                int j = i % nums.length;
                while (!stack.isEmpty()
                        && nums[j] > nums[stack.peek()]) {
                    res[stack.peek()] = nums[j];
                    stack.pop();
                }
                stack.push(j);
            }

            return res;
        }
    }
}
