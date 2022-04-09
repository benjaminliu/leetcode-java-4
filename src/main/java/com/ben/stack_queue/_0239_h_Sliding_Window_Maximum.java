package com.ben.stack_queue;

import com.ben.util.PrintUtil;

import java.util.*;

public class _0239_h_Sliding_Window_Maximum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

//        int[] nums = new int[]{4, 2};
//        int k = 2;
        PrintUtil.printArray(new Solution().maxSlidingWindow(nums, k));
    }

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            if (n < 2) {
                return nums;
            }
            int[] res = new int[n - k + 1];
            //Store the max number's idx
            Deque<Integer> dq = new LinkedList<>();
            for (int end = 0; end < n; end++) {
                int start = end - k + 1;

                // remove numbers out of range k
                if (!dq.isEmpty() && dq.peek() < start) {
                    dq.poll();
                }

                //Remove the smaller numbers in k range as they are useless
                while (!dq.isEmpty() && nums[end] >= nums[dq.peekLast()]) {
                    dq.pollLast();
                }

                dq.offer(end);

                //start >=0 means the window is full (length is k)
                if (start >= 0) {
                    res[start] = nums[dq.peek()];
                }
            }
            return res;
        }
    }
}
