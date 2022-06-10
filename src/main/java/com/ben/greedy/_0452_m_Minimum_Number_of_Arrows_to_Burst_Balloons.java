package com.ben.greedy;

import com.ben.util.PrintUtil;

import java.util.Arrays;

public class _0452_m_Minimum_Number_of_Arrows_to_Burst_Balloons {

    public static void main(String[] args) {
//        int[][] points = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
        int[][] points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
//        int[][] points = new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};

        PrintUtil.printLn(new Solution2().findMinArrowShots(points));
    }

    static class Solution {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, (a, b) -> {
                return Integer.compare(a[0], b[0]);
            });

            int count = 1;
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] > points[i - 1][1]) {
                    count++;
                } else {

                    //更新有边界, 取小值
                    points[i][1] = Math.min(points[i][1], points[i - 1][1]);
                }
            }
            return count;
        }
    }


    static class Solution2 {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, (a, b) -> {
                return Integer.compare(a[0], b[0]);
            });

            int res = 1;
            int curRight = points[0][1];
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] <= curRight) {
                    if (points[i][1] < curRight) {
                        curRight = points[i][1];
                    }
                    continue;
                }
                res++;
                curRight = points[i][1];
            }

            return res;
        }
    }
}
