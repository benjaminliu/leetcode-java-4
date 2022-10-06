package com.ben.tree.bst;

import com.ben.common.TreeNode;
import com.ben.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class _1382_m_Balance_a_Binary_Search_Tree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);


        TreeNode newRoot = new Solution().balanceBST(root);
        PrintUtil.printLn(newRoot.val);
    }

   static class Solution {

        private List<TreeNode> nodes;

        public TreeNode balanceBST(TreeNode root) {
            if (root == null) {
                return null;
            }

            nodes = new ArrayList<>();

            getAllNodes(root);

            return buildNewTree(nodes, 0, nodes.size() - 1);
        }

        private TreeNode buildNewTree(List<TreeNode> nodes, int start, int end) {
            if (start > end) {
                return null;
            }

            int mid = (start + end) / 2;
            TreeNode root = nodes.get(mid);
            root.left = buildNewTree(nodes, start, mid - 1);
            root.right = buildNewTree(nodes, mid + 1, end);
            return root;
        }

        private void getAllNodes(TreeNode root) {
            if (root.left != null) {
                getAllNodes(root.left);
            }

            nodes.add(root);

            if (root.right != null) {
                getAllNodes(root.right);
            }
        }
    }
}
