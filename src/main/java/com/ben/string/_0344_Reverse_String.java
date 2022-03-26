package com.ben.string;

public class _0344_Reverse_String {

    class Solution {
        public void reverseString(char[] s) {
            if (s.length < 2) {
                return;
            }


            int left = 0;
            int right = s.length - 1;
            while (left < right) {
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
                left++;
                right--;
            }
        }
    }
}
