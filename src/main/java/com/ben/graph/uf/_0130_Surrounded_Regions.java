package com.ben.graph.uf;

public class _0130_Surrounded_Regions {

    class Solution1 {
        private final char O = 'O';
        private final char X = 'X';

        public void solve(char[][] board) {
            if (board.length == 0) {
                return;
            }

            int m = board.length;
            int n = board[0].length;


            int dummy = m * n;
            //leave a space for dummy
            UF uf = new UF(dummy + 1);

            //把4边的O和dummy连接起来
            for (int i = 0; i < m; i++) {
                int tmp = i * n;
                if (board[i][0] == O) {
                    uf.union(tmp, dummy);
                }
                if (board[i][n - 1] == O) {
                    uf.union(tmp + (n - 1), dummy);
                }
            }

            for (int i = 0; i < n; i++) {
                if (board[0][i] == O) {
                    uf.union(i, dummy);
                }
                if (board[m - 1][i] == O) {
                    uf.union(n * (m - 1) + i, dummy);
                }
            }

            //up right down left
            int[][] d = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {

                    //如果board[i][j]是O，就把它和它上下左右的O连接起来,
                    //如果board[i][j]和dummy连接了， 说明它没有被X包围
                    if (board[i][j] == O) {
                        //up right down left
                        for (int k = 0; k < 4; k++) {
                            int x = i + d[k][0];
                            int y = j + d[k][1];
                            if (board[x][y] == O) {
                                uf.union(x * n + y, i * n + j);
                            }
                        }
                    }
                }
            }

            // 所有不和 dummy 连通的 O，都要被替换成X
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (!uf.connected(dummy, i * n + j)) {
                        board[i][j] = X;
                    }
                }
            }
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
