package com.ben.tree.binarytree.traversal;

import com.ben.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _0145_Binary_Tree_Postorder_Traversal {

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            helper(root, res);

            return res;
        }

        private void helper(TreeNode root, List<Integer> res) {
            if (root.left != null) {
                helper(root.left, res);
            }
            if (root.right != null) {
                helper(root.right, res);
            }
            res.add(root.val);
        }
    }

    static class Solution2 {
        // postorder is left - right - mid
        // we can get  mid - right - left, and then reverse the order
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                res.add(cur.val);

                if (cur.left != null) {
                    stack.push(cur.left);
                }
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            }

            Collections.reverse(res);
            return res;
        }
    }
}
