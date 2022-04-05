package com.ben.stack_queue;

import com.ben.util.PrintUtil;

import java.util.Set;
import java.util.Stack;

public class _0020_Valid_Parentheses {
    public static void main(String[] args) {
        PrintUtil.printLn(new Solution().isValid("()"));
    }

    static class Solution {
        private static final char smallParentheseStart = '(';
        private static final char smallParentheseEnd = ')';
        private static final char midParentheseStart = '[';
        private static final char midParentheseEnd = ']';
        private static final char bigParentheseStart = '{';
        private static final char bigParentheseEnd = '}';
        private static final Set<Character> startSet = Set.of(
                smallParentheseStart,
                midParentheseStart,
                bigParentheseStart
        );


        public boolean isValid(String s) {
            if (s.length() < 2) {
                return false;
            }

            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();

            for (char c : chars) {
                if (startSet.contains(c)) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char tmp = stack.pop();
                    if (smallParentheseEnd == c) {
                        if (tmp != smallParentheseStart) {
                            return false;
                        }
                    } else if (midParentheseEnd == c) {
                        if (tmp != midParentheseStart) {
                            return false;
                        }
                    } else {
                        if (tmp != bigParentheseStart) {
                            return false;
                        }
                    }
                }
            }
            return stack.isEmpty();
        }
    }


    static class Solution2 {
        private static final char smallParentheseStart = '(';
        private static final char smallParentheseEnd = ')';
        private static final char midParentheseStart = '[';
        private static final char midParentheseEnd = ']';
        private static final char bigParentheseStart = '{';
        private static final char bigParentheseEnd = '}';

        public boolean isValid(String s) {
            if (s.length() < 2) {
                return false;
            }

            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();

            for (char c : chars) {
                if (c == smallParentheseStart) {
                    stack.push(smallParentheseEnd);
                } else if (c == midParentheseStart) {
                    stack.push(midParentheseEnd);
                } else if (c == bigParentheseStart) {
                    stack.push(bigParentheseEnd);
                } else if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() != c) {
                    return false;
                } else {
                    stack.pop();
                }
            }

            return stack.isEmpty();
        }
    }
}
