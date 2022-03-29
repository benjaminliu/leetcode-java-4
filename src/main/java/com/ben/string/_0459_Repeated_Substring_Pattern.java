package com.ben.string;

import com.ben.util.PrintUtil;

public class _0459_Repeated_Substring_Pattern {

    public static void main(String[] args) {
        PrintUtil.printLn(new Solution().repeatedSubstringPattern("asdfasdfasdf"));
    }

    static class Solution {
        public boolean repeatedSubstringPattern(String s) {
            if (s.length() < 2) {
                return false;
            }
            char[] chars = s.toCharArray();
            int len = s.length();
            int[] next = getNext(chars);

            if (next[len - 1] != 0 && (len % (len - (next[len - 1])) == 0)) {
                return true;
            }

            return false;
        }

        private int[] getNext(char[] chars) {
            int[] next = new int[chars.length];
            next[0] = 0;
            int j = 0;

            for (int i = 1; i < chars.length; i++) {
                while (j > 0 && chars[i] != chars[j]) {
                    j = next[j - 1];
                }

                if (chars[i] == chars[j]) {
                    j++;
                }

                next[i] = j;
            }

            return next;
        }
    }
}
