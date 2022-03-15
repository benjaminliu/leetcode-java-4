package com.ben.array;

import com.ben.util.PrintUtil;

public class _0059_m_Spiral_Matrix_II {

    public static void main(String[] args) {
        PrintUtil.printArrayOfArray(new Solution().generateMatrix(4));
    }

    static class Solution {
        /**
         * 0 left -> right
         * 1 up -> down
         * 2 right -> left
         * 3 down -> up
         */
        private int direction = 0;

        private void resetDirection() {
            direction = 0;
        }

        private void changeDirection() {
            direction++;
            direction = direction % 4;
        }

        private boolean toRight() {
            return direction == 0;
        }

        private boolean toDown() {
            return direction == 1;
        }

        private boolean toLeft() {
            return direction == 2;
        }

        private boolean toUp() {
            return direction == 3;
        }

        public int[][] generateMatrix(int n) {
            resetDirection();
            int target = n * n;

            int[][] res = new int[n][n];

            int rowStart = 0;
            int rowEnd = n - 1;
            int colStart = 0;
            int colEnd = n - 1;

            int row = 0;
            int col = 0;

            int cur = 1;
            while (cur < target) {
                res[row][col] = cur;
                cur++;

                if (toRight()) {
                    if (col == colEnd) {
                        changeDirection();
                        row++;
                        rowStart++;
                    } else {
                        col++;
                    }
                } else if (toDown()) {
                    if (row == rowEnd) {
                        changeDirection();
                        col--;
                        colEnd--;
                    } else {
                        row++;
                    }
                } else if (toLeft()) {
                    if (col == colStart) {
                        changeDirection();
                        row--;
                        rowEnd--;
                    } else {
                        col--;
                    }
                } else {
                    // to up
                    if (row == rowStart) {
                        changeDirection();
                        col++;
                        colStart++;
                    } else {
                        row--;
                    }
                }
            }
            res[row][col] = cur;

            return res;
        }
    }
}
