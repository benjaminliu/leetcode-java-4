package com.ben.tree.bst;

import com.ben.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0501_Find_Mode_in_Binary_Search_Tree {

    class Solution {
        List<Integer> resList;
        int count;
        int maxCount;
        Integer pre;

        public int[] findMode(TreeNode root) {
            resList = new ArrayList<>();
            maxCount = 0;
            count = 0;
            pre = null;

            inorder(root);

            int[] res = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }
            return res;
        }

        private void inorder(TreeNode root) {
            if (root.left != null) {
                inorder(root.left);
            }

            //inorder
            int val = root.val;
            if (pre == null || pre != val) {
                count = 1;
            } else {
                count++;
            }

            if (count > maxCount) {
                maxCount = count;
                resList.clear();
                resList.add(val);
            } else if (count == maxCount) {
                resList.add(val);
            }

            pre = root.val;

            if (root.right != null) {
                inorder(root.right);
            }
        }
    }
}
