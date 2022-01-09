package com.ben.graph.mst.kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1584_Min_Cost_to_Connect_All_Points {

    public class Solution {
        public int minCostConnectPoints(int[][] points) {
            int n = points.length;

            List<int[]> edges = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int xi = points[i][0];
                    int xj = points[i][1];

                    int yi = points[j][0];
                    int yj = points[j][1];

                    int weight = Math.abs(xi - yi) + Math.abs(xj - yj);

                    edges.add(new int[]{i, j, weight});
                }
            }

            //sort by weight
            Collections.sort(edges, (a, b) -> a[2] - b[2]);

            int mst = 0;
            UF uf = new UF(n);
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];

                if (uf.connected(u, v)) {
                    continue;
                }
                mst += weight;
                uf.union(u, v);
            }

            return mst;
        }


        public class UF {
            private int count;
            private int[] parent;
            private int[] size;

            public UF(int n) {
                this.count = n;
                parent = new int[n];
                size = new int[n];

                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);

                if (rootP == rootQ) {
                    return;
                }

                // To balance the new tree, we add the smaller tree into the bigger tree as a subtree
                if (size[p] > size[q]) {
                    parent[rootQ] = rootP;
                    size[rootP] += size[rootQ];
                } else {
                    parent[rootP] = rootQ;
                    size[rootQ] += size[rootP];
                }
                count--;
            }

            public boolean connected(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                return rootP == rootQ;
            }

            private int find(int x) {
                //parent[x] == x means x is root node
                while (parent[x] != x) {
                    //compress the path to root
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }

            public int count() {
                return count;
            }
        }
    }
}
