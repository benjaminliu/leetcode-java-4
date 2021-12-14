package com.ben.graph;

import java.util.*;

public class _1631_Path_With_Minimum_Effort {

    public static void main(String[] args) {
        int[][] heights = new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(new Solution1().minimumEffortPath(heights));
    }

    static class Solution1 {


        class State {
            // 矩阵中的一个位置
            int x, y;
            // 从起点 (0, 0) 到当前位置的最小体力消耗（距离）
            int effortFromStart;

            State(int x, int y, int effortFromStart) {
                this.x = x;
                this.y = y;
                this.effortFromStart = effortFromStart;
            }
        }

        public int minimumEffortPath(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;

            int lastX = m - 1;
            int lastY = n - 1;

            int[][] effortTo = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(effortTo[i], Integer.MAX_VALUE);
            }
            effortTo[0][0] = 0;

            Queue<State> pq = new PriorityQueue<>((a, b) -> {
                return a.effortFromStart - b.effortFromStart;
            });

            pq.offer(new State(0, 0, 0));

            while (!pq.isEmpty()) {
                State cur = pq.poll();
                int curX = cur.x;
                int curY = cur.y;
                int curEffortFromStart = cur.effortFromStart;

                if (curX == lastX && curY == lastY) {
                    return curEffortFromStart;
                }

                if (curEffortFromStart > effortTo[curX][curY]) {
                    continue;
                }

                for (int[] neighbor : adj(heights, curX, curY)) {
                    int nx = neighbor[0];
                    int ny = neighbor[1];

                    int effortToNext = Math.max(
                            effortTo[curX][curY],
                            Math.abs(heights[curX][curY] - heights[nx][ny])
                    );

                    if (effortToNext < effortTo[nx][ny]) {
                        effortTo[nx][ny] = effortToNext;
                        pq.offer(new State(nx, ny, effortToNext));
                    }
                }
            }
            return -1;
        }


        // 方向数组，上下左右的坐标偏移量
        static int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        List<int[]> adj(int[][] matrix, int x, int y) {
            int m = matrix.length;
            int n = matrix[0].length;
            List<int[]> neighbors = new ArrayList<>();
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                //out of matrix
                if (nx >= m || nx < 0 || ny >= n || ny < 0) {
                    continue;
                }
                neighbors.add(new int[]{nx, ny});
            }

            return neighbors;
        }
    }
}
