package com.ben.tree;

import com.ben.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _0105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public static void main(String[] args) {
//        int[] preorder = new int[]{1, 2, 3};
//        int[] inorder = new int[]{3, 2, 1};

//        int[] preorder = new int[]{3,9,20,15,7};
//        int[] inorder = new int[]{9,3,15,20,7};

//        int[] preorder = new int[]{1, 2, 3};
//        int[] inorder = new int[]{2, 3, 1};

//        int[] preorder = new int[]{4, 2, 1, 3};
////        int[] inorder = new int[]{1, 2, 3, 4};

//        int[] preorder = new int[]{5, 3, 1, 2, 4};
//        int[] inorder = new int[]{1, 2, 3, 4, 5};

//        int[] preorder = new int[]{1, 2};
//        int[] inorder = new int[]{1, 2};

        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);

        System.out.println(root);
    }

    //We increase preOrderCurIdx by 1 if we create a new root node (root node of the sub-tree)
    static int preOrderCurIdx;

    static public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        preOrderCurIdx = 0;
        return buildTree(preorder, inorder, map, 0, inorder.length - 1);
    }

    static public TreeNode buildTree(int[] preorder, int[] inorder, Map<Integer, Integer> map, int inOrderStart, int inOrderEnd) {
        if (inOrderStart > inOrderEnd) {
            return null;
        }

        int rootValue = preorder[preOrderCurIdx++];
        TreeNode root = new TreeNode(rootValue);
        int inOrderCurIdx = map.get(rootValue);

        root.left = buildTree(preorder, inorder, map, inOrderStart, inOrderCurIdx - 1);
        root.right = buildTree(preorder, inorder, map, inOrderCurIdx + 1, inOrderEnd);
        return root;
    }


    static public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildTree2(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    static public TreeNode buildTree2(int[] preOrder, int preStart, int preEnd,
                                      int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootValue = preOrder[preStart];

        int inCurIdx = inStart;
        for (; inCurIdx <= inEnd; inCurIdx++) {
            if (inOrder[inCurIdx] == rootValue) {
                break;
            }
        }

        TreeNode root = new TreeNode(rootValue);
        int leftSubTreeSize = inCurIdx - inStart;
        root.left = buildTree2(preOrder, preStart + 1, preStart + leftSubTreeSize, inOrder, inStart, inCurIdx - 1);
        root.right = buildTree2(preOrder, preStart + leftSubTreeSize + 1, preEnd, inOrder, inCurIdx + 1, inEnd);

        return root;
    }


    static public TreeNode buildTree1(int[] preorder, int[] inorder) {
        preOrderCurIdx = 0;
        return buildTree1(preorder, inorder, 0, preorder.length - 1);
    }

    static public TreeNode buildTree1(int[] preOrder, int[] inOrder, int inOrderStart, int inOrderEnd) {
        if (inOrderStart > inOrderEnd) {
            return null;
        }

        //Create a root node of sub-tree, and move the preOrderCurIdx to next
        int curValue = preOrder[preOrderCurIdx++];
        TreeNode root = new TreeNode(curValue);

        //No left or right sub-tree, just return
        if (inOrderStart == inOrderEnd) {
            return root;
        }

        //We find the root in inOrder,  so we can split it into left sub-tree and right sub-tree
        int inOrderCurIdx = inOrderStart;
        for (; inOrderCurIdx <= inOrderEnd; inOrderCurIdx++) {
            if (inOrder[inOrderCurIdx] == curValue) {
                break;
            }
        }

        root.left = buildTree1(preOrder, inOrder, inOrderStart, inOrderCurIdx - 1);

        root.right = buildTree1(preOrder, inOrder, inOrderCurIdx + 1, inOrderEnd);

        return root;
    }
}
