package com.ben.map_set;

import com.ben.util.PrintUtil;

import java.util.HashSet;
import java.util.Set;

public class _0202_Happy_Number {

    public static void main(String[] args) {

        PrintUtil.printLn(new Solution().isHappy(2));
    }

    static class Solution {
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<>();

            while (!(n == 1 || set.contains(n))) {
                set.add(n);
                n = newN(n);
            }

            return n == 1;
        }

        private int newN(int n) {
            int newN = 0;
            while (n > 0) {
                int tmp = n % 10;
                newN += tmp * tmp;
                n = n / 10;
            }
            return newN;
        }
    }
}
