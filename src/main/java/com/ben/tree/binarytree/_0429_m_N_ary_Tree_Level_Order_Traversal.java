package com.ben.tree.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0429_m_N_ary_Tree_Level_Order_Traversal {

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> level = new ArrayList<>();
                while (size > 0) {
                    Node cur = queue.poll();
                    level.add(cur.val);
                    for (Node c : cur.children) {
                        queue.offer(c);
                    }
                    size--;
                }
                res.add(level);
            }
            return res;
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
