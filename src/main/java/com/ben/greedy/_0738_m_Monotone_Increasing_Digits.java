package com.ben.greedy;

import com.ben.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class _0738_m_Monotone_Increasing_Digits {

    public static void main(String[] args) {
        PrintUtil.printLn(new Solution().monotoneIncreasingDigits(10));
    }

    static class Solution {
        public int monotoneIncreasingDigits(int n) {
            if (n < 10) {
                return n;
            }

            List<Integer> digits = new ArrayList<>();

            while (n > 0) {
                digits.add(n % 10);
                n /= 10;
            }

            for (int i = 0, end = digits.size() - 1; i < end; i++) {
                int cur = digits.get(i);
                int higher = digits.get(i + 1);
                if (cur < 0) {
                    digits.set(i, 9);
                    digits.set(i + 1, higher - 1);
                } else if (cur < higher) {
                    //lower level digit smaller than higher level digit
                    for (int j = 0; j <= i; j++) {
                        digits.set(j, 9);
                    }
                    digits.set(i + 1, higher - 1);
                }
            }
            int res = 0;
            for (int i = digits.size() - 1; i >= 0; i--) {
                res = res * 10 + digits.get(i);
            }
            return res;
        }
    }

    static class Solution2 {
        public int monotoneIncreasingDigits(int n) {
            String s = String.valueOf(n);
            char[] chars = s.toCharArray();
            int start = s.length();
            for (int i = s.length() - 2; i >= 0; i--) {
                if (chars[i] > chars[i + 1]) {
                    chars[i]--;
                    start = i + 1;
                }
            }

            for (int i = start; i < s.length(); i++) {
                chars[i] = '9';
            }

            return Integer.parseInt(String.valueOf(chars));
        }
    }
}
