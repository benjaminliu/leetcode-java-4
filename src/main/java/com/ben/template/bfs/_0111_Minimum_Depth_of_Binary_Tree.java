package com.ben.template.bfs;

import com.ben.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _0111_Minimum_Depth_of_Binary_Tree {

    public static class Solution1 {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<TreeNode> childQueue = new LinkedList<>();
            int depth = 1;
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }

                if (cur.left != null) {
                    childQueue.offer(cur.left);
                }

                if (cur.right != null) {
                    childQueue.offer(cur.right);
                }

                if (queue.isEmpty()) {
                    depth++;
                    Queue<TreeNode> tmp = queue;
                    queue = childQueue;
                    childQueue = tmp;
                }
            }
            return depth;
        }
    }

    public static class Solution2 {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            int depth = 1;
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    if (cur.left == null && cur.right == null) {
                        return depth;
                    }

                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                depth++;
            }
            return depth;
        }
    }
}
