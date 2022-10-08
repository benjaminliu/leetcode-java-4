package com.ben.backtracking;

import com.ben.util.PrintUtil;

public class _0052_h_N_Queens_II {

    public static void main(String[] args) {
        PrintUtil.printLn(new Solution().totalNQueens(4));
    }

    static class Solution {

        private final int queen = 1;

        private int count;

        public int totalNQueens(int n) {
            count = 0;

            int[][] board = new int[n][n];

            helper(board, 0);

            return count;
        }

        private void helper(int[][] board, int row) {
            if (row >= board.length) {
                count++;
                return;
            }

            outter:
            for (int col = 0; col < board.length; col++) {
                int i = row - 1;
                int j = col - 1;
                while (i >= 0 && j >= 0) {
                    if (board[i][j] == queen) {
                        continue outter;
                    }
                    i--;
                    j--;
                }

                i = row - 1;
                j = col + 1;
                while (i >= 0 && j < board.length) {
                    if (board[i][j] == queen) {
                        continue outter;
                    }
                    i--;
                    j++;
                }

                i = row - 1;
                j = col;
                while (i >= 0) {
                    if (board[i][j] == queen) {
                        continue outter;
                    }
                    i--;
                }

                board[row][col] = queen;
                helper(board, row + 1);
                board[row][col] = 0;
            }
        }
    }
}
