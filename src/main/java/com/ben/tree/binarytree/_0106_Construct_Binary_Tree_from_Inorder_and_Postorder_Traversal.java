package com.ben.tree.binarytree;

import com.ben.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public static void main(String[] args) {

        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};

        TreeNode root = buildTree(inorder, postorder);

        System.out.println();
    }

    static public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderValueToIdxMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderValueToIdxMap.put(inorder[i], i);
        }

        return buildTree(0, inorder.length - 1,
                postorder, 0, postorder.length - 1,
                inOrderValueToIdxMap);
    }

    static public TreeNode buildTree(int inorderStart, int inorderEnd,
                                     int[] postorder, int postorderStart, int postorderEnd,
                                     Map<Integer, Integer> inOrderValueToIdxMap) {
        if (inorderStart > inorderEnd) {
            return null;
        }

        int rootValue = postorder[postorderEnd];

        TreeNode root = new TreeNode(rootValue);
        if (inorderStart == inorderEnd) {
            return root;
        }

        int inorderRootIdx = inOrderValueToIdxMap.get(rootValue);

        int leftBranchSize = inorderRootIdx - inorderStart;

        root.left = buildTree(inorderStart, inorderRootIdx - 1,
                postorder, postorderStart, postorderStart + leftBranchSize - 1,
                inOrderValueToIdxMap);

        root.right = buildTree(inorderRootIdx + 1, inorderEnd,
                postorder, postorderStart + leftBranchSize, postorderEnd - 1,
                inOrderValueToIdxMap);

        return root;
    }
}
