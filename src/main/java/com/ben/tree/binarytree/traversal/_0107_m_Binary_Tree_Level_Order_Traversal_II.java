package com.ben.tree.binarytree.traversal;

import com.ben.common.TreeNode;

import java.util.*;

public class _0107_m_Binary_Tree_Level_Order_Traversal_II {

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int count = queue.size();
                List<Integer> tmp = new ArrayList<>(count);
                while (count > 0) {
                    TreeNode cur = queue.poll();
                    tmp.add(cur.val);
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                    count--;
                }
                res.add(tmp);
            }
            Collections.reverse(res);
            return res;
        }
    }
}
