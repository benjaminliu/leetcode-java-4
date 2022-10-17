package com.ben.graph;

public class _0463_Island_Perimeter {

    class Solution {
        public int islandPerimeter(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            int lastRow = row - 1;
            int lastCol = col - 1;
            int island = 1;

            int perimeter = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    boolean isIsLand = grid[i][j] == island;
                    if (j == 0) {
                        if (isIsLand) {
                            //left border
                            perimeter++;
                        }
                    } else {
                        if (isIsLand) {
                            if (grid[i][j - 1] != island) {
                                perimeter++;
                            }
                        } else {
                            if (grid[i][j - 1] == island) {
                                perimeter++;
                            }
                        }
                    }
                    if (j == lastCol) {
                        if (isIsLand) {
                            //right border
                            perimeter++;
                        }
                    }
                    if (i == 0) {
                        if (isIsLand) {
                            //up border
                            perimeter++;
                        }
                    } else {
                        if (isIsLand) {
                            if (grid[i - 1][j] != island) {
                                perimeter++;
                            }
                        } else {
                            if (grid[i - 1][j] == island) {
                                perimeter++;
                            }
                        }
                    }
                    if (i == lastRow) {
                        if (isIsLand) {
                            //bottom border
                            perimeter++;
                        }
                    }
                }
            }

            return perimeter;
        }
    }
}
