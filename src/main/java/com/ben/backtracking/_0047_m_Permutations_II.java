package com.ben.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0047_m_Permutations_II {

    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {

            Arrays.sort(nums);
            boolean[] visited = new boolean[nums.length];

            List<List<Integer>> res = new ArrayList<>();

            helper(nums, new ArrayList<Integer>(), res, visited);


            return res;
        }

        private void helper(int[] nums,   ArrayList<Integer> group, List<List<Integer>> res, boolean[] visited) {
            if(group.size() == nums.length){
                res.add(new ArrayList<>(group));
                return;
            }

            for(int i =0;i < nums.length;i++){
                if(i > 0 && visited[i-1] == false && nums[i] == nums[i-1]){
                    continue;
                }
                if(visited[i]){
                    continue;
                }
                visited[i] = true;
                group.add(nums[i]);
                helper(nums, group, res, visited);
                group.remove(group.size()-1);
                visited[i]  = false;
            }
        }
    }
}
