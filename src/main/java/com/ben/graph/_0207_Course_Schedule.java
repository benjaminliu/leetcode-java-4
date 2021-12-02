package com.ben.graph;

import java.util.ArrayList;
import java.util.List;

public class _0207_Course_Schedule {

    public static class Solution1 {

        // 记录一次 traverse 递归经过的节点
        private boolean[] onPath;

        private boolean[] visited;

        boolean hasCycle = false;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);

            onPath = new boolean[numCourses];
            visited = new boolean[numCourses];

            for (int i = 0; i < numCourses; i++) {
                traverse(graph, i);
            }

            return !hasCycle;
        }

        private void traverse(List<Integer>[] graph, int idx) {
            if (onPath[idx]) {
                hasCycle = true;
                return;
            }

            if (visited[idx]) {
                return;
            }

            visited[idx] = true;

            onPath[idx] = true;

            for (int i : graph[idx]) {
                traverse(graph, i);
            }

            onPath[idx] = false;
        }

        List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = new ArrayList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] edge : prerequisites) {
                int from = edge[1];
                int to = edge[0];
                graph[from].add(to);
            }
            return graph;
        }
    }
}
