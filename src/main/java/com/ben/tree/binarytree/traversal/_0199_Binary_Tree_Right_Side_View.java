package com.ben.tree.binarytree.traversal;

import com.ben.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0199_Binary_Tree_Right_Side_View {

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            List<List<Integer>> traversal = new ArrayList<>();
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
                traversal.add(tmp);
            }

            for (List<Integer> list : traversal) {
                res.add(list.get(list.size() - 1));
            }
            return res;
        }
    }

    class Solution2 {
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null)
                return new ArrayList();
            Queue<TreeNode> queue = new LinkedList();
            queue.offer(root);
            List<Integer> res = new ArrayList();

            while (!queue.isEmpty()) {
                int size = queue.size();

                while (size-- > 0) {
                    TreeNode cur = queue.poll();
                    //only add last node for each level
                    if (size == 0)
                        res.add(cur.val);

                    if (cur.left != null)
                        queue.offer(cur.left);
                    if (cur.right != null)
                        queue.offer(cur.right);
                }
            }

            return res;
        }
    }
}
