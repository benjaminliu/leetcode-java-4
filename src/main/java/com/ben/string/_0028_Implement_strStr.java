package com.ben.string;

import com.ben.util.PrintUtil;

public class _0028_Implement_strStr {

    public static void main(String[] args) {
        PrintUtil.printLn(new Solution().strStr("aabaabaaf", "aabaaf"));
    }

    static class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }

            if (haystack.length() < needle.length()) {
                return -1;
            }

            char[] hChars = haystack.toCharArray();
            char[] pattern = needle.toCharArray();
            int[] next = getNext(pattern);
            int patternIdx = 0;

            for (int i = 0; i < haystack.length(); i++) {
                while (patternIdx > 0 && hChars[i] != pattern[patternIdx]) {
                    patternIdx = next[patternIdx - 1];
                }
                if (hChars[i] == pattern[patternIdx]) {
                    patternIdx++;
                }
                if (patternIdx == needle.length()) {
                    return (i - needle.length() + 1);
                }
            }
            return -1;
        }

        public int[] getNext(char[] chars) {
            int[] next = new int[chars.length];
            next[0] = 0;
            int preIdx = 0;

            for (int right = 1; right < chars.length; right++) {
                while (preIdx > 0 && chars[preIdx] != chars[right]) {
                    preIdx = next[preIdx - 1];
                }

                if (chars[preIdx] == chars[right]) {
                    preIdx++;
                }
                next[right] = preIdx;
            }
            return next;
        }
    }
}
