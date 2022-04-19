package com.ben.tree.binarytree;

import java.util.List;

public class _0559_Maximum_Depth_of_N_ary_Tree {


    class Solution {
        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }

            if (root.children == null || root.children.isEmpty()) {
                return 1;
            }

            int max = maxDepth(root.children.get(0));
            for (int i = 1; i < root.children.size(); i++) {
                max = Math.max(max, maxDepth(root.children.get(i)));
            }

            return max + 1;
        }
    }

    static class Node {
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
}
