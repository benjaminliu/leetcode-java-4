package com.ben.graph.uf;

import com.ben.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class _0685_h_Redundant_Connection_II {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1, 2},
                {1, 3},
                {2, 3}
        };
        PrintUtil.printArray(new Solution().findRedundantDirectedConnection(edges));
    }

    static class Solution {

        private final int n;
        private int[] parent;

        public Solution() {
            n = 1010;
            parent = new int[n];

            initParent();
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
            if (u == v) {
                return;
            }

            parent[v] = u;
        }

        private boolean connect(int u, int v) {
            u = find(u);
            v = find(v);
            return u == v;
        }

        private void initParent() {
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        private int[] getRemoveEdge(int[][] edges) {
            initParent();
            for (int i = 0; i < edges.length; i++) {
                //Already connected,  a circle was found
                if (connect(edges[i][0], edges[i][1])) {
                    return edges[i];
                }
                union(edges[i][0], edges[i][1]);
            }
            return null;
        }

        private boolean isTreeAfterRemoveEdge(int[][] edges, int deleteEdge) {
            initParent();
            for (int i = 0; i < edges.length; i++) {
                if (i == deleteEdge) {
                    continue;
                }

                //Already connected, a circle was found, not a tree
                if (connect(edges[i][0], edges[i][1])) {
                    return false;
                }

                union(edges[i][0], edges[i][1]);
            }
            return true;
        }

        public int[] findRedundantDirectedConnection(int[][] edges) {
            int[] inDegree = new int[n];
            for (int i = 0; i < edges.length; i++) {
                inDegree[edges[i][1]] += 1;
            }

            List<Integer> twoDegree = new ArrayList<>();
            for (int i = edges.length - 1; i >= 0; i--) {
                if (inDegree[edges[i][1]] == 2) {
                    twoDegree.add(i);
                }
            }

            if (!twoDegree.isEmpty()) {
                if (isTreeAfterRemoveEdge(edges, twoDegree.get(0))) {
                    return edges[twoDegree.get(0)];
                }
                return edges[twoDegree.get(1)];
            }

            return getRemoveEdge(edges);
        }
    }
}
