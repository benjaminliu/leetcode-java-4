package com.ben.tree.binarytree;

import com.ben.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0652_Find_Duplicate_Subtrees {
    public static void main(String[] args) {

    }

    static HashMap<String, Integer> memo;
    static List<TreeNode> res;

    static public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        memo = new HashMap<>();
        res = new ArrayList<>();

        traverse(root);

        return res;
    }

    static public String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String cur = left + "," + right + "," + root.val;

        int count = memo.getOrDefault(cur, 0);
        if (count == 1) {
            res.add(root);
        }
        memo.put(cur, count + 1);

        return cur;
    }
}
