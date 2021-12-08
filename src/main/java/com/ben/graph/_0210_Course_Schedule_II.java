package com.ben.graph;

import com.ben.util.PrintUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0210_Course_Schedule_II {

    public static void main(String[] args) {
        PrintUtil.printArray(new Solution1().findOrder(2, new int[][]{{0, 1}}));
    }

    public static class Solution1 {

        // 记录一次 traverse 递归经过的节点
        private boolean[] onPath;

        private boolean[] visited;

        boolean hasCycle;

        List<Integer> postOrder;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);

            if (!canFinish(numCourses, graph)) {
                return new int[0];
            }

            postOrder = new ArrayList<>();
            visited = new boolean[numCourses];

            for (int i = 0; i < numCourses; i++) {
                postOrderTraverse(graph, i);
            }

            // 将后序遍历结果反转，然后转化成 int[] 类型
            Collections.reverse(postOrder);
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = postOrder.get(i);
            }
            return res;
        }

        private void postOrderTraverse(List<Integer>[] graph, int i) {
            if (visited[i]) {
                return;
            }

            visited[i] = true;
            for (int j : graph[i]) {
                postOrderTraverse(graph, j);
            }
            //Post-order
            postOrder.add(i);
        }

        private boolean canFinish(int numCourses, List<Integer>[] graph) {
            onPath = new boolean[numCourses];
            visited = new boolean[numCourses];
            hasCycle = false;

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

        private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
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
