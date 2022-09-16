package com.ben.monotonicStack;

import java.util.Deque;
import java.util.LinkedList;

public class _0042_h_Trapping_Rain_Water {

    class Solution {
        public int trap(int[] height) {
            if (height.length <= 2) {
                return 0;
            }

            Deque<Integer> stack = new LinkedList<>();
            stack.push(0);

            int sum = 0;
            for (int i = 1; i < height.length; i++) {
                if (height[i] < height[stack.peek()]) {
                    stack.push(i);
                } else if (height[i] == height[stack.peek()]) {
                    stack.pop();
                    stack.push(i);
                } else {
                    int right = height[i];
                    while (!stack.isEmpty()
                            && right > height[stack.peek()]) {
                        int cur = stack.pop();

                        if (!stack.isEmpty()) {
                            int left = stack.peek();
                            int h = Math.min(height[left], right) - height[cur];
                            int w = i - left - 1;
                            int hold = h * w;
                            if (hold > 0) {
                                sum += hold;
                            }
                        }
                    }

                    stack.push(i);
                }
            }
            return sum;
        }
    }
}
