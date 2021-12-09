package com.ben.graph;

import java.util.*;

public class _0743_Network_Delay_Time {

    public static void main(String[] args) {
        int[][] times = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(new Solution1().networkDelayTime(times, 4, 2));
    }

    public static class Solution1 {
        public int networkDelayTime(int[][] times, int n, int k) {
            // 节点编号是从 1 开始的，所以要一个大小为 n + 1 的邻接表
            List<int[]>[] graph = new LinkedList[n + 1];

            for (int i = 0; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }

            //build graph
            for (int[] edge : times) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];
                graph[from].add(new int[]{to, weight});
            }

            int[] disTo = dijkstra(k, graph);

            int res = 0;
            for (int i = 1; i < disTo.length; i++) {
                if (disTo[i] == Integer.MAX_VALUE) {
                    // 有节点不可达，返回 -1
                    return -1;
                }
                res = Math.max(res, disTo[i]);
            }

            return res;
        }

        public static class State {
            // 图节点的 id
            int id;
            // 从 start 节点到当前节点的距离
            int distFromStart;

            State(int id, int distFromStart) {
                this.id = id;
                this.distFromStart = distFromStart;
            }
        }

        private int[] dijkstra(int start, List<int[]>[] graph) {
            int[] disTo = new int[graph.length];
            Arrays.fill(disTo, Integer.MAX_VALUE);

            disTo[start] = 0;

            Queue<State> pq = new PriorityQueue<>((a, b) -> {
                return a.distFromStart - b.distFromStart;
            });

            pq.offer(new State(start, 0));

            while (!pq.isEmpty()) {
                State cur = pq.poll();
                int curId = cur.id;
                int curDisFromStart = cur.distFromStart;

                if (curDisFromStart > disTo[curId]) {
                    continue;
                }

                for (int[] neighbor : graph[curId]) {
                    int nextId = neighbor[0];
                    int disToNext = disTo[curId] + neighbor[1];
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
