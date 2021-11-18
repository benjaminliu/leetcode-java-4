package com.ben.tree.bst;

public class _0096_Unique_Binary_Search_Trees {

    public static void main(String[] args) {

        System.out.println(numTrees(3));
    }

    private static int[][] memo;

    static public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    static private int count(int start, int end) {
        if (start >= end) {
            return 1;
        }
        if (memo[start][end] != 0) {
            return memo[start][end];
        }

        int res = 0;
        for (int i = start; i <= end; i++) {
            int left = count(start, i - 1);
            int right = count(i + 1, end);

            res += left * right;
        }

        memo[start][end] = res;
        return res;
    }
}
