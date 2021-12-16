package com.ben.graph.bipartition;

import java.util.LinkedList;
import java.util.Queue;

public class _0785_Is_Graph_Bipartite {


    class Solution1 {
        private boolean ok = true;
        private boolean[] colors;
        private boolean[] visited;

        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            colors = new boolean[n];
            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    traverse(graph, i);
                }
            }
            return ok;
        }

        //DFS
        private void traverse(int[][] graph, int i) {
            if (!ok) {
                return;
            }

            visited[i] = true;
            for (int neighbor : graph[i]) {
                if (!visited[neighbor]) {
                    colors[neighbor] = !colors[i];

                    traverse(graph, neighbor);
                } else {
                    if (colors[neighbor] == colors[i]) {
                        ok = false;
                        return;
                    }
                }
            }
        }
    }

    class Solution2 {
        private boolean ok = true;
        private boolean[] colors;
        private boolean[] visited;

        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            colors = new boolean[n];
            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    traverse(graph, i);
                }
            }

            return ok;
        }

        //BFS
        private void traverse(int[][] graph, int i) {
            if (!ok) {
                return;
            }

            Queue<Integer> queue = new LinkedList<>();

            queue.offer(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int neighbor : graph[cur]) {
                    if (!visited[neighbor]) {
                        colors[neighbor] = !colors[cur];

                        queue.offer(neighbor);
                        visited[neighbor] = true;
                    } else {
                        if (colors[neighbor] == colors[cur]) {
                            ok = false;
                            return;
                        }
                    }
                }
            }
        }
    }
}
