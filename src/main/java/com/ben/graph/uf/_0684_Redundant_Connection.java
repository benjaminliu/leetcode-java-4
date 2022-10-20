package com.ben.graph.uf;

public class _0684_Redundant_Connection {

    class Solution {
        private int n;
        private int[] parent;

        public Solution() {
            n = 1005;
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int u) {
            if (u == parent[u]) {
                return u;
            }

            parent[u] = find(parent[u]);
            return parent[u];
        }

        private void union(int u, int v) {
            u = find(u);
            v = find(v);
            if (v == u) {
                return;
            }

            parent[v] = u;
        }

        private boolean connect(int u, int v) {
            u = find(u);
            v = find(v);
            return u == v;
        }

        public int[] findRedundantConnection(int[][] edges) {
            for (int i = 0; i < edges.length; i++) {

                //Already in the same group, this edge formed a circle
                if (connect(edges[i][0], edges[i][1])) {
                    return edges[i];
                } else {
                    union(edges[i][0], edges[i][1]);
                }
            }

            return null;
        }
    }
}
