package com.ben.greedy;

public class _1221_Split_a_String_in_Balanced_Strings {

    static
    class Solution {
        public int balancedStringSplit(String s) {
            int res = 0;
            int rCount = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'R') {
                    rCount++;
                } else {
                    rCount--;
                }

                if (rCount == 0) {
                    res++;
                }
            }

            return res;
        }
    }
}
