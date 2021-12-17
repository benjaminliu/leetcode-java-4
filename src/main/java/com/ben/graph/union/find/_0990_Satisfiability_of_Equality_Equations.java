package com.ben.graph.union.find;

public class _0990_Satisfiability_of_Equality_Equations {

    class Solution {
        public boolean equationsPossible(String[] equations) {
            UF uf = new UF(26);
            for (String eq : equations) {
                if (eq.charAt(1) == '=') {
                    char x = eq.charAt(0);
                    char y = eq.charAt(3);
                    uf.union(x - 'a', y - 'a');
                }
            }

            for (String eq : equations) {
                if (eq.charAt(1) == '!') {
                    char x = eq.charAt(0);
                    char y = eq.charAt(3);
                    if (uf.connected(x - 'a', y - 'a')) {
                        return false;
                    }
                }
            }

            return true;
        }

        public class UF {
            private int count;
            private int[] parent;
            private int[] size;

            public UF(int n) {
                this.count = n;
                this.parent = new int[n];
                this.size = new int[n];

                for (int i = 0; i < n; i++) {
                    //root's parent is itself
                    this.parent[i] = i;
                    //each tree's initialing size is 1
                    this.size[i] = 1;
                }
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                //share same root, they are already connected
                if (rootP == rootQ) {
                    return;
                }

                //add smaller tree into bigger tree
                if (size[rootP] > size[rootQ]) {
                    parent[rootQ] = rootP;
                    size[rootP] += size[rootQ];
                } else {
                    parent[rootP] = rootQ;
                    size[rootQ] += size[rootP];
                }

                //After union two tree, the count of tree decreased
                count--;
            }

            public boolean connected(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                //if they have same root, they are connected
                return rootP == rootQ;
            }

            private int find(int x) {
                //if x's parent is not itself,  x is not the root
                while (parent[x] != x) {
                    //change x's parent to its grandpa
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
