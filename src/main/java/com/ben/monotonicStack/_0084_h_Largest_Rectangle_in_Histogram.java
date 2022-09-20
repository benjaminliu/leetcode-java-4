package com.ben.monotonicStack;

import java.util.Deque;
import java.util.LinkedList;

public class _0084_h_Largest_Rectangle_in_Histogram {

    class Solution {
        public int largestRectangleArea(int[] height) {
            //insert two 0,  one at beginning, the other one at the end.
            int[] newHeight = new int[height.length + 2];
            for (int i = 0; i < height.length; i++) {
                newHeight[i + 1] = height[i];
            }

            Deque<Integer> stack = new LinkedList<>();
            stack.push(0);
            int maxArea = 0;
            for (int i = 1; i < newHeight.length; i++) {
                if (newHeight[i] > newHeight[stack.peek()]) {
                    stack.push(i);
                } else if (newHeight[i] == newHeight[stack.peek()]) {
                    stack.pop();
                    stack.push(i);
                } else {
                    while (newHeight[i] < newHeight[stack.peek()]) {
                        int cur = stack.peek();
                        stack.pop();
                        int left = stack.peek();
                        int right = i;
                        int w = right - left - 1;
                        int h = newHeight[cur];
                        int area = w * h;
                        maxArea = Math.max(maxArea, area);
                    }
                    stack.push(i);
                }
            }

            return maxArea;
        }
    }
}
