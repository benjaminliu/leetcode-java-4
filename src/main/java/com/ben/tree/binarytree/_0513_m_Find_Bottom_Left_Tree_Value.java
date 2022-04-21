package com.ben.tree.binarytree;

import com.ben.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _0513_m_Find_Bottom_Left_Tree_Value {

    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int leftMost = root.val;
            while (!queue.isEmpty()) {
                int size = queue.size();
                leftMost = queue.peek().val;
                while (size > 0) {
                    TreeNode cur = queue.poll();
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                    size--;
                }
            }
            return leftMost;
        }
    }
}
