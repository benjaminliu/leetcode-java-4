package com.ben.dp;

import com.ben.util.PrintUtil;

public class _0343_m_Integer_Break {

    public static void main(String[] args) {
        PrintUtil.printLn(new Solution2().integerBreak(10));
    }

    class Solution {
        // split n into several 3s and (a 2 or a 4)
        public int integerBreak(int n) {
            if (n == 2) {
                return 1;
            }
            if (n == 3) {
                return 2;
            }
            if (n == 4) {
                return 4;
            }
            int product = 1;
            while (n > 4) {
                product *= 3;
                n -= 3;
            }

            return product * n;
        }
    }

    static class Solution2 {
        private static int[] dp = new int[59];
        private static int maxN = 2;

        static {
            dp[2] = 1;
        }

        public int integerBreak(int n) {
            if (n <= maxN) {
                //already calculated, just get from cache
                return dp[n];
            }

            for (int i = maxN + 1; i <= n; i++) {
                for (int j = 1, end = i / 2; j <= end; j++) {
                    //we split i into j + (i-j), j is the left part,  (i-j) is the right part
                    int right = i - j;

                    //Decide if we want to split right into smaller parts, dp[right] is the max product of right
                    //let's assume right is 3, dp[3] is 2, and 3 is bigger than 2, so we don't need to split the right
                    int rightProduct = Math.max(right, dp[right]);
                    int newProduct = j * rightProduct;

                    dp[i] = Math.max(dp[i], newProduct);
                }
            }

            maxN = n;
            return dp[n];
        }
    }
}
