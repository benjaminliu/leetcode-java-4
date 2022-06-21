package com.ben.dp;

public class _0509_Fibonacci_Number {

    class Solution {
        public int fib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n < 2) {
                return 1;
            }

            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 1;

            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n];
        }
    }
}
