package com.ben.stack_queue;

import com.ben.util.PrintUtil;

import java.util.Stack;
import java.util.function.BiFunction;


public class _0150_Evaluate_Reverse_Polish_Notation {

    public static void main(String[] args) {
        PrintUtil.printLn(new Solution().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            BiFunction<Integer, Integer, Integer> lastOperation = null;
            for (int i = 0; i < tokens.length; i++) {
                String tmp = tokens[i];
                if (tmp.equals("+")) {
                    lastOperation = (t, r) -> t + r;
                } else if (tmp.equals("-")) {
                    lastOperation = (t, r) -> t - r;
                } else if (tmp.equals("*")) {
                    lastOperation = (t, r) -> t * r;
                } else if (tmp.equals("/")) {
                    lastOperation = (t, r) -> t / r;
                } else {
                    int num = Integer.parseInt(tmp);
                    stack.push(num);
                    continue;
                }
                int right = stack.pop();
                int left = stack.pop();
                stack.push(lastOperation.apply(left, right));
            }

            return stack.pop();
        }

    }
}
