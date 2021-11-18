package com.ben.tree.bst;

import com.ben.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0095_Unique_Binary_Search_Trees_II {

    static public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return build(1, n);
    }

    private static List<TreeNode> build(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = build(start, i - 1);
            List<TreeNode> rightTree = build(i + 1, end);

            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
