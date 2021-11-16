package com.ben.tree.bst;

import com.ben.common.TreeNode;
import com.ben.util.PrintUtil;
import com.ben.util.TreeUtil;

import java.util.HashMap;
import java.util.Map;

public class _0230_Kth_Smallest_Element_in_a_BST {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTree(5,3,6,2,4,null,null,1);

        int val = kthSmallest(root, 3);
        System.out.println(val);
    }

    private static Map<Integer, Integer> subtreeCountMap;

    static public int kthSmallest(TreeNode root, int k) {

        subtreeCountMap = new HashMap<>();
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        }
        count++;
        if (k == count) {
            return root.val;
        }

        return kthSmallest(root.right, k - count);
    }

    static private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Integer count = subtreeCountMap.get(root.val);
        if (count == null) {
            count = 1 + countNodes(root.left) + countNodes(root.right);
            subtreeCountMap.put(root.val, count);
        }
        return count;
    }


    private static int val;
    private static int rank;
    private static boolean found;

    static public int kthSmallest1(TreeNode root, int k) {
        rank = 0;
        found = false;
        traverse(root, k);

        return val;
    }

    static private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        traverse(root.left, k);
        if (found) {
            return;
        }
        rank++;
        if (rank == k) {
            val = root.val;
            found = true;
            return;
        }

        traverse(root.right, k);
    }
}
