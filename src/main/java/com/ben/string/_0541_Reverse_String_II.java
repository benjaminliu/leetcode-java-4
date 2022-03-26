package com.ben.string;

import com.ben.util.PrintUtil;

public class _0541_Reverse_String_II {

    public static void main(String[] args) {
        PrintUtil.printLn(new Solution().reverseStr("abcdefg", 2));
    }

    static class Solution {
        public String reverseStr(String s, int k) {
            char[] chars = s.toCharArray();

            int start = 0;
            while (start < s.length()) {
                int end = start + k - 1;
                if (end >= s.length()) {
                    end = s.length() - 1;
                }

                revert(chars, start, end);
                start = start + 2 * k;
            }

            return new String(chars);
        }

        private void revert(char[] chars, int start, int end) {
            while (start < end) {
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                start++;
                end--;
            }
        }
    }
}
