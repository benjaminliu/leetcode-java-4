package com.ben.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _0051_h_N_Queens {

    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();
            boolean[][] board = new boolean[n][n];
            helper(board, 0, res);

            return res;
        }

        private void helper(boolean[][] board, int row, List<List<String>> res) {
            if (row == board.length) {
                res.add(transferBoard(board));
                return;
            }

            for (int j = 0; j < board.length; j++) {
                if (canBeQueue(board, row, j)) {
                    board[row][j] = true;
                    helper(board, row + 1, res);
                    board[row][j] = false;
                }
            }
        }

        private boolean canBeQueue(boolean[][] board, int row, int col) {
            for (int i = 0; i < row; i++) {
                if (board[i][col]) {
                    return false;
                }
            }

            int tmpRow = row - 1;
            int tmpCol = col - 1;
            while (tmpRow >= 0 && tmpCol >= 0) {
                if (board[tmpRow][tmpCol]) {
                    return false;
                }
                tmpRow--;
                tmpCol--;
            }

            tmpRow = row - 1;
            tmpCol = col + 1;
            while (tmpRow >= 0 && tmpCol < board.length) {
                if (board[tmpRow][tmpCol]) {
                    return false;
                }
                tmpRow--;
                tmpCol++;
            }

            return true;
        }

        private List<String> transferBoard(boolean[][] board) {
            List<String> res = new ArrayList<>(board.length);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < board.length; i++) {
                sb.setLength(0);
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == true) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                res.add(sb.toString());
            }

            return res;
        }
    }
}
