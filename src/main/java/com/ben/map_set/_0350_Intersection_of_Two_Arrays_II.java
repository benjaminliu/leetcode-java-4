package com.ben.map_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0350_Intersection_of_Two_Arrays_II {

    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map1 = getMap(nums1);
            Map<Integer, Integer> map2 = getMap(nums2);

            if (map1.size() > map2.size()) {
                Map<Integer, Integer> tmp = map1;
                map1 = map2;
                map2 = tmp;
            }

            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                int val2 = map2.getOrDefault(entry.getKey(), 0);
                for (int i = 0; i < Math.min(val2, entry.getValue()); i++) {
                    list.add(entry.getKey());
                }
            }

            int[] res = new int[list.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = list.get(i);
            }

            return res;
        }

        private Map<Integer, Integer> getMap(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            return map;
        }
    }
}
