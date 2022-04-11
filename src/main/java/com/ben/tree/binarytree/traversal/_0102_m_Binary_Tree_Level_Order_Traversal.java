package com.ben.tree.binarytree.traversal;

import com.ben.common.TreeNode;
import com.ben.util.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0102_m_Binary_Tree_Level_Order_Traversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        PrintUtil.printListOfList(new Solution().levelOrder(root));
    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
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
            return res;
        }
    }
}
