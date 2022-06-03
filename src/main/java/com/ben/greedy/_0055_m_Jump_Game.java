package com.ben.greedy;

public class _0055_m_Jump_Game {

    class Solution {
        public boolean canJump(int[] nums) {
            int lastIdx = 0;
            for (int i = 1; i < nums.length; i++) {
                int distance = i - lastIdx;
                if (nums[lastIdx] < distance) {
                    return false;
                }

                if (nums[i] > nums[lastIdx] - distance) {
                    lastIdx = i;
                }
            }
            return true;
        }
    }

    class Solution2 {
        public boolean canJump(int[] nums) {
            if (nums.length == 1) {
                return true;
            }
            int cover = 0;
            for (int i = 0; i <= cover; i++) {
                cover = Math.max(i + nums[i], cover);
                if (cover >= nums.length - 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
