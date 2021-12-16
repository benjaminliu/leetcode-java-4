package com.ben.graph.bipartition;

import java.util.LinkedList;
import java.util.List;

public class _0886_Possible_Bipartition {

    public static void main(String[] args) {
        int[][] dislikes = new int[][]{{1, 2}, {1, 3}, {2, 4}};

        System.out.println(new Solution1().possibleBipartition(4, dislikes));
    }

    static class Solution1 {
        boolean ok = true;
        boolean[] colors;
        boolean[] visited;

        public boolean possibleBipartition(int n, int[][] dislikes) {
            colors = new boolean[n + 1];
            visited = new boolean[n + 1];

            List<Integer>[] graph = buildGraph(n, dislikes);

            for (int i = 0; i <= n; i++) {
                if (!visited[i]) {
                    traverse(graph, i);
                }
            }

            return ok;
        }

        private List<Integer>[] buildGraph(int n, int[][] dislikes) {
            List<Integer>[] graph = new LinkedList[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] edge : dislikes) {
                int v = edge[1];
                int w = edge[0];
                // 「无向图」相当于「双向图」
                // v -> w
                graph[v].add(w);
                // w -> v
                graph[w].add(v);
            }
            return graph;
        }

        private void traverse(List<Integer>[] graph, int i) {
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
}
