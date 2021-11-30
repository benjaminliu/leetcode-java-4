package com.ben.tree.binarytree;

import com.ben.common.TreeNode;

public class _0222_Count_Complete_Tree_Nodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        System.out.println(new Solution1().countNodes(root));
    }

    public static class Solution1 {
        static public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }

            int leftDepth = countDepth(root.left);
            int rightDepth = countDepth(root.right);

            if (leftDepth == rightDepth) {
                // Left sub tree's depth equals right subtree's depth
                // which means the left subtree is a perfect tree

                int leftSubTree = perfectBinaryTreeCount(leftDepth);

                // tree nodes count = left sub tree nodes count + root node + right sub tree nodes count;
                return leftSubTree + 1 + countNodes(root.right);
            } else {
                //Left sub tree's depth not equals right subtree's depth
                // which means the right subtree is a perfect tree

                int rightSubTree = perfectBinaryTreeCount(rightDepth);

                return countNodes(root.left) + 1 + rightSubTree;
            }
        }

        private static int perfectBinaryTreeCount(int depth) {
            return (int) Math.pow(2, depth) - 1;
        }

        private static int countDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return countDepth(root.left) + 1;
        }
    }


    public static class Solution2 {
        public int countNodes(TreeNode root) {
            TreeNode l = root, r = root;
            // 记录左、右子树的高度
            int hl = 0, hr = 0;
            while (l != null) {
                l = l.left;
                hl++;
            }
            while (r != null) {
                r = r.right;
                hr++;
            }
            // 如果左右子树的高度相同，则是一棵满二叉树
            if (hl == hr) {
                return (int) Math.pow(2, hl) - 1;
            }
            // 如果左右高度不同，则按照普通二叉树的逻辑计算
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
