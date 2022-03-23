package com.ben.map_set;

import java.util.HashMap;
import java.util.Map;

public class _0454_m_4Sum_II {

    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer, Integer> map = new HashMap<>();

            int res = 0;
            for (int i : nums1) {
                for (int j : nums2) {
                    int tmp = i + j;
                    map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                }
            }

            for (int i : nums3) {
                for (int j : nums4) {
                    int tmp = 0 - (i + j);
                    res += map.getOrDefault(tmp, 0);
                }
            }
            return res;
        }
    }
}
