package com.ben.greedy;

public class _0045_Jump_Game_II {

    class Solution {
        public int jump(int[] nums) {
            if (nums.length == 1) {
                return 0;
            }

            int curDistance = 0;
            int steps = 0;
            int nextDistance = 0;

            for (int i = 0; i < nums.length; i++) {
                nextDistance = Math.max(nums[i] + i, nextDistance);

                if (i == curDistance) {
                    if (curDistance >= nums.length - 1) {
                        //Reach to end
                        break;
                    } else {
                        //need a new step
                        steps++;
                        curDistance = nextDistance;
                    }
                }
            }
            return steps;
        }
    }
}
