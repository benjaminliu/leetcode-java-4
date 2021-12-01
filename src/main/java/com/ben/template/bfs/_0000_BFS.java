package com.ben.template.bfs;

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
}
