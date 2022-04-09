package com.ben.tree.binarytree;

import com.ben.common.TreeNode;

import java.util.*;

public class _0144_Binary_Tree_Preorder_Traversal {

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            helper(root, res);
            return res;
        }

        private void helper(TreeNode root, List<Integer> res) {
            res.add(root.val);
            if (root.left != null) {
                helper(root.left, res);
            }

            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    class Solution2 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                res.add(cur.val);

                //Push right fist, because we use stack, and stack is LIFO
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
            return res;
        }
    }
}
