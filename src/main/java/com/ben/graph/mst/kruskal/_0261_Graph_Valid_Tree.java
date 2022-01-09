package com.ben.graph.mst.kruskal;

public class _0261_Graph_Valid_Tree {

    public class Solution1 {
        public boolean validTree(int n, int[][] edges) {
            UF uf = new UF(n);
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                //if u and v already connected and there is another edge connect u to v, there is a cycle.
                if (uf.connected(u, v)) {
                    return false;
                }
                uf.union(u, v);
            }

            //only 1 count in uf, means there is only 1 tree
            return uf.count() == 1;
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
