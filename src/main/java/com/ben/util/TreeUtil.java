package com.ben.util;

import com.ben.common.TreeNode;

public class TreeUtil {
    public static TreeNode createTree(Integer... arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        return createTree(arr, 0);
    }

    private static TreeNode createTree(Integer[] arr, int cur) {
        if (cur >= 0 && cur < arr.length) {
            Integer curValue = arr[cur];
            if (curValue != null) {
                TreeNode root = new TreeNode(curValue);
                int right = (cur + 1) * 2;
                int left = right - 1;
                root.left = createTree(arr, left);
                root.right = createTree(arr, right);
                return root;
            }
        }
        return null;
    }
}
