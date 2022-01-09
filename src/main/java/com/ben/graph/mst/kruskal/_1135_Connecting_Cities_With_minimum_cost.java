package com.ben.graph.mst.kruskal;

import java.util.Arrays;

public class _1135_Connecting_Cities_With_minimum_cost {

    public class Solution1 {
        public int minimumCost(int n, int[][] connections) {
            // the city start with 1,  so we need n+1
            UF uf = new UF(n + 1);

            //Sort by weight asc
            Arrays.sort(connections, (a, b) -> a[2] - b[2]);

            int mst = 0;

            for (int[] edge : connections) {
                int u = edge[0];
                int v = edge[1];

                int weight = edge[2];

                //Add this edge will create a cycle
                if (uf.connected(u, v)) {
                    continue;
                }

                mst += weight;
                uf.union(u, v);
            }

            // the city start with 1,  so 0 is not in use.
            // the uf has 2 count,  one is 0,  the other one is the connected tree
            if (uf.count == 2) {
                return mst;
            }

            return -1;
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
