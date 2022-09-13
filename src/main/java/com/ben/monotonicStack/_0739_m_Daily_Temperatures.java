package com.ben.monotonicStack;

import java.util.Deque;
import java.util.LinkedList;

public class _0739_m_Daily_Temperatures {


    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] res = new int[temperatures.length];

            Deque<Integer> stack = new LinkedList<>();
            stack.push(0);

            for (int i = 0; i < temperatures.length; i++) {
                if (temperatures[i] <= temperatures[stack.peek()]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty()
                            && temperatures[i] > temperatures[stack.peek()]) {
                        res[stack.peek()] = i - stack.peek();
                        stack.pop();
                    }
                    stack.push(i);
                }
            }

            return res;
        }
    }
}
