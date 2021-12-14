package com.ben.graph;

import java.util.*;

public class _1514_Path_with_Maximum_Probability {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {0, 2}};
        double[] probs = new double[]{0.5, 0.5, 0.2};

        System.out.println(new Solution1().maxProbability(3, edges, probs, 0, 2));
    }

    static class Solution1 {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            List<double[]>[] graph = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new LinkedList<>();
            }

            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                int from = edge[0];
                int to = edge[1];
                double prob = succProb[i];
                graph[from].add(new double[]{to, prob});
                graph[to].add(new double[]{from, prob});
            }

            return dijkstra(start, end, graph);
        }

        private double dijkstra(int start, int end, List<double[]>[] graph) {
            double[] probTo = new double[graph.length];
            Arrays.fill(probTo, -1);

            probTo[start] = 1;

            Queue<State> pq = new PriorityQueue<>((a, b) -> {
                return Double.compare(b.probFromStart, a.probFromStart);
            });

            pq.offer(new State(start, 1));

            while (!pq.isEmpty()) {
                State cur = pq.poll();
                int curId = cur.id;
                double curProbFromStart = cur.probFromStart;

                if (curId == end) {
                    return curProbFromStart;
                }

                if (curProbFromStart < probTo[curId]) {
                    continue;
                }

                for (double[] neighbor : graph[curId]) {
                    int nextId = (int) neighbor[0];
                    double probToNext = probTo[curId] * neighbor[1];

                    if (probTo[nextId] < probToNext) {
                        probTo[nextId] = probToNext;
                        pq.offer(new State(nextId, probToNext));
                    }
                }
            }

            return 0;
        }
    }


    public static class State {
        // 图节点的 id
        int id;
        // 从 start 节点到当前节点的距离
        double probFromStart;

        State(int id, double probFromStart) {
            this.id = id;
            this.probFromStart = probFromStart;
        }
    }
}
