package com.ben.graph;

import com.ben.util.PrintUtil;

import java.util.*;

public class _0210_Course_Schedule_II {

    public static void main(String[] args) {
        PrintUtil.printArray(new Solution2().findOrder(2, new int[][]{{0, 1}}));
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

    public static class Solution2 {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] prerequisitesCount = new int[numCourses];
            int[] res = new int[numCourses];

            List<Integer>[] graph = new ArrayList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < prerequisites.length; i++) {
                int pre = prerequisites[i][1];
                int cur = prerequisites[i][0];
                prerequisitesCount[cur]++;
                graph[pre].add(cur);
            }

            int finishedCourseCount = 0;
            Queue<Integer> finishedCourse = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                //those course does not have prerequisites can be finished first
                if (prerequisitesCount[i] == 0) {
                    finishedCourse.offer(i);
                    res[finishedCourseCount++] = i;
                }
            }

            while (!finishedCourse.isEmpty()) {
                //finished course
                int aFinishedCourse = finishedCourse.poll();
                for (int to : graph[aFinishedCourse]) {
                    //this course has a finished prerequisites, so we decrease its prerequisites count by 1
                    prerequisitesCount[to]--;
                    //if this course's all prerequisites have been finished, we can finished this course
                    if (prerequisitesCount[to] == 0) {
                        finishedCourse.add(to);
                        res[finishedCourseCount++] = to;
                    }
                }
            }

            if (finishedCourseCount == numCourses) {
                return res;
            }

            return new int[0];
        }
    }
}
