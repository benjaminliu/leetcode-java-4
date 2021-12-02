package com.ben.graph;

public class _0000Graph {

    //对于邻接表，好处是占用的空间少。
    //但是，邻接表无法快速判断两个节点是否相邻。

    //比如说我想判断节点1是否和节点3相邻，我要去邻接表里1对应的邻居列表里查找3是否存在。但对于邻接矩阵就简单了，只要看看matrix[1][3]就知道了，效率高。

    //图和多叉树最大的区别是，图是可能包含环的，你从图的某一个节点开始遍历，有可能走了一圈又回到这个节点。所以，如果图包含环，遍历框架就要一个visited数组进行辅助
    //当然，当有向图含有环的时候才需要visited数组辅助，如果不含环，连visited数组都省了，基本就是多叉树的遍历。

    //图的遍历
//    Graph graph;
//    boolean[] visited;
//
//    /* 图遍历框架 */
//    void traverse(Graph graph, int s) {
//        if (visited[s]) return;
//        // 经过节点 s
//        visited[s] = true;
//        for (TreeNode neighbor : graph.neighbors(s))
//            traverse(neighbor);
//        // 离开节点 s
//        visited[s] = false;
//    }
}
