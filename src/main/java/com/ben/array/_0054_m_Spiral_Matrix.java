package com.ben.array;

import com.ben.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class _0054_m_Spiral_Matrix {

    public static void main(String[] args) {
        int[][] metrics = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        PrintUtil.printList(new Solution().spiralOrder(metrics));
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

        public List<Integer> spiralOrder(int[][] matrix) {
            resetDirection();

            int rowCount = matrix.length;
            int colCount = matrix[0].length;
            int target = rowCount * colCount;
            List<Integer> res = new ArrayList<>(target);

            int rowStart = 0;
            int rowEnd = rowCount - 1;
            int colStart = 0;
            int colEnd = colCount - 1;

            int row = 0;
            int col = 0;

            int count = 0;
            while (count < target) {
                res.add(matrix[row][col]);
                count++;

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

            return res;
        }
    }
}
