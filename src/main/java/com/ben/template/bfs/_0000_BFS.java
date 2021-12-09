package com.ben.template.bfs;

import com.ben.common.PolyTreeNode;
import com.ben.common.TreeNode;

import java.util.*;

public class _0000_BFS {

    //BFS 算法都是用「队列」这种数据结构，每次将一个节点周围的所有节点加入队列

    //BFS 找到的路径一定是最短的，但代价就是空间复杂度比 DFS 大很多

    //BFS 出现的常见场景，问题的本质就是让你在一幅「图」中找到从起点start到终点target的最近距离，这个例子听起来很枯燥，但是 BFS 算法问题其实都是在干这个事儿

    //BFS本质上就是一幅「图」，让你从一个起点，走到终点，问最短路径。

    //Template

    // 计算从起点 start 到终点 target 的最近距离
//    int BFS(Node start, Node target) {
//        Queue<Node> q; // 核心数据结构
//        Set<Node> visited; // 避免走回头路
//
//        q.offer(start); // 将起点加入队列
//        visited.add(start);
//        int step = 0; // 记录扩散的步数
//
//        while (q not empty) {
//            int sz = q.size();
//            /* 将当前队列中的所有节点向四周扩散 */
//            for (int i = 0; i < sz; i++) {
//                Node cur = q.poll();
//                /* 划重点：这里判断是否到达终点 */
//                if (cur is target) {
//                    return step;
//                }
//
//                /* 将 cur 的相邻节点加入队列 */
//                for (Node x : cur.adj()) {
//                    if (x not in visited) {
//                        q.offer(x);
//                        visited.add(x);
//                    }
//                }
//            }
//            /* 划重点：更新步数在这里 */
//            step++;
//        }
//    }

    public static class BinaryTree {
        //levelTraverse
        public void bfs(TreeNode root) {
            if (root == null) {
                return;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            int depth = 1;
            while (!q.isEmpty()) {
                int sz = q.size();
                for (int i = 0; i < sz; i++) {
                    TreeNode cur = q.poll();

                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
                System.out.println(depth++);
            }
        }

        void levelTraverseWithoutDepth(TreeNode root) {
            if (root == null) {
                return;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                TreeNode cur = q.poll();

                //We don't know the level depth
                if (cur.left != null) {
                    q.offer(cur.left);
                }

                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }

        public static class State {
            int depth;
            TreeNode node;

            public State(TreeNode node, int depth) {
                this.depth = depth;
                this.node = node;
            }
        }

        void levelTraverseWithState(TreeNode root) {
            if (root == null) {
                return;
            }

            Queue<State> q = new LinkedList<>();
            q.offer(new State(root, 1));

            while (!q.isEmpty()) {
                State cur = q.poll();

                if (cur.node.left != null) {
                    q.offer(new State(cur.node.left, cur.depth + 1));
                }

                if (cur.node.right != null) {
                    q.offer(new State(cur.node.right, cur.depth + 1));
                }
            }
        }
    }

    public static class PolyTree {
        //levelTraverse
        public void bfs(PolyTreeNode root) {
            if (root == null) {
                return;
            }

            Queue<PolyTreeNode> q = new LinkedList<>();
            q.offer(root);

            int depth = 1;
            while (!q.isEmpty()) {
                int sz = q.size();
                for (int i = 0; i < sz; i++) {
                    PolyTreeNode cur = q.poll();

                    for (PolyTreeNode child : cur.children) {
                        q.offer(child);
                    }
                }
                System.out.println(depth++);
            }
        }
    }

    public static class Graph {

        // 输入起点，进行 BFS 搜索
//        int BFS(Node start) {
//            Queue<Node> q; // 核心数据结构
//            Set<Node> visited; // 避免走回头路
//
//            q.offer(start); // 将起点加入队列
//            visited.add(start);
//
//            int step = 0; // 记录搜索的步数
//            while (q not empty) {
//                int sz = q.size();
//                /* 将当前队列中的所有节点向四周扩散一步 */
//                for (int i = 0; i < sz; i++) {
//                    Node cur = q.poll();
//                    printf("从 %s 到 %s 的最短距离是 %s", start, cur, step);
//
//                    /* 将 cur 的相邻节点加入队列 */
//                    for (Node x : cur.adj()) {
//                        if (x not in visited) {
//                            q.offer(x);
//                            visited.add(x);
//                        }
//                    }
//                }
//                step++;
//            }
//        }
    }


    public static class Dijkstra {

        public static class State {
            // 图节点的 id
            int id;
            // 从 start 节点到当前节点的距离
            int distFromStart;

            public State(int id, int distFromStart) {
                this.id = id;
                this.distFromStart = distFromStart;
            }
        }

        int weight(int from, int to) {
            return 0;
        }

        List<Integer> adj(List<Integer>[] graph, int s) {
            return graph[s];
        }

        int[] dijkstra(int start, List<Integer>[] graph) {
            int nodeSize = graph.length;

            int[] disTo = new int[nodeSize];

            Arrays.fill(disTo, Integer.MAX_VALUE);

            disTo[start] = 0;

            Queue<State> pq = new PriorityQueue<State>((a, b) -> {
                return a.distFromStart - b.distFromStart;
            });

            pq.offer(new State(start, 0));

            while (!pq.isEmpty()) {
                //Every time, we fetch the shortest path
                State cur = pq.poll();
                int curId = cur.id;
                int curDistFromStart = cur.distFromStart;

                if (curDistFromStart > disTo[curId]) {
                    // 已经有一条更短的路径到达 curNode 节点了
                    continue;
                }

                for (int nextId : adj(graph, curId)) {
                    int disToNext = disTo[curId] + weight(curId, nextId);

                    if (disTo[nextId] > disToNext) {
                        disTo[nextId] = disToNext;
                        pq.offer(new State(nextId, disToNext));
                    }
                }
            }
            return disTo;
        }
    }

}
