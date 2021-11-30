package com.ben.template.dfs_backtracking;

import com.ben.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class _0051_N_Queens {

    public static void main(String[] args) {
        PrintUtil.printList(new Solution1().solveNQueens(4));
    }

    public static class Solution1 {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();
            boolean[][] board = new boolean[n][n];
            backTracking(board, 0, res);

            return res;
        }

        private void backTracking(boolean[][] board, int row, List<List<String>> res) {
            if (row == board.length) {
                res.add(transferBoard(board));
                return;
            }

            for (int j = 0; j < board.length; j++) {
                if (canBeQueue(board, row, j)) {
                    board[row][j] = true;
                    backTracking(board, row + 1, res);
                    board[row][j] = false;
                }
            }
        }

        private boolean canBeQueue(boolean[][] board, int row, int col) {
            //No queue in the column,
            for (int i = 0; i < row; i++) {
                if (board[i][col] == true) {
                    return false;
                }
            }

            //No queue in the diagonal to upper left
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == true) {
                    return false;
                }
            }

            //No queue in the diagonal to upper right
            for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
                if (board[i][j] == true) {
                    return false;
                }
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
