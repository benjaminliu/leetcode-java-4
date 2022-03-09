package com.ben.array;

import com.ben.util.PrintUtil;

public class _0367_Valid_Perfect_Square {
    public static void main(String[] args) {
        PrintUtil.printLn(new Solution().isPerfectSquare(2147483647));
    }

    static class Solution {
        public boolean isPerfectSquare(int num) {
            if (num == 1) {
                return true;
            }

            long left = 1;
            long right = num;
            while (left <= right) {
                long mid = (left + right) / 2;
                long pow = mid * mid;
                if (pow == num) {
                    return true;
                }
                if (pow > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return false;
        }
    }
}
