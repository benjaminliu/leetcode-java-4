package com.ben.string;

import com.ben.util.PrintUtil;

public class _0151_m_Reverse_Words_in_a_String {

    public static void main(String[] args) {
        PrintUtil.printLn(new Solution().reverseWords("   a good   example   "));
    }

    static class Solution {
        public String reverseWords(String s) {
            if (s.length() == 0) {
                return s;
            }
            char[] chars = s.toCharArray();

            int start = 0;
            //remove leading blanks
            while (chars[start] == ' ') {
                start++;
                if (start == s.length()) {
                    // only blank
                    return "";
                }
            }

            int end = s.length() - 1;
            //remove trailing blanks
            while (chars[end] == ' ') {
                end--;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = start; i <= end; i++) {
                if (chars[i] == ' ' && chars[i - 1] == ' ') {
                    continue;
                }
                sb.append(chars[i]);
            }

            char[] newChars = sb.toString().toCharArray();

            revert(newChars, 0, newChars.length - 1);

            int left = 0;
            while (left < newChars.length) {
                int right = left;
                while (right < newChars.length && newChars[right] != ' ') {
                    right++;
                }

                revert(newChars, left, right - 1);
                left = right + 1;
            }

            return new String(newChars);
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
