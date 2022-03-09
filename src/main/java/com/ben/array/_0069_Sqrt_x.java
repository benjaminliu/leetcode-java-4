package com.ben.array;

import com.ben.util.PrintUtil;

public class _0069_Sqrt_x {

    public static void main(String[] args) {
        PrintUtil.printLn(new Solution().mySqrt(8));
    }

    static class Solution {
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }

            long left = 1;
            long right = x;
            while (left <= right) {
                long mid = (left + right) / 2;
                long pow = mid * mid;
                if (pow == x) {
                    return (int) mid;
                }
                if (pow < x) {
                    if ((mid + 1) * (mid + 1) > x) {
                        return (int) mid;
                    }
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return -1;
        }
    }
}
