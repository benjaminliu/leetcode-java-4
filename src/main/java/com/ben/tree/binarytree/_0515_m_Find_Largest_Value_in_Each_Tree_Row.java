package com.ben.tree.binarytree;

import com.ben.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0515_m_Find_Largest_Value_in_Each_Tree_Row {

    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null){
                return res;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()){
                int size = queue.size();
                int max = Integer.MIN_VALUE;
                while (size>0){
                    TreeNode cur = queue.poll();
                    if(cur.val> max){
                        max = cur.val;
                    }

                    if(cur.left!= null){
                        queue.offer(cur.left);
                    }
                    if(cur.right!= null){
                        queue.offer(cur.right);
                    }
                    size--;
                }
                res.add(max);
            }

            return res;
        }
    }
}
