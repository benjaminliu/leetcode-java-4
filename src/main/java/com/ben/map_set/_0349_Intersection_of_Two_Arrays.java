package com.ben.map_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _0349_Intersection_of_Two_Arrays {

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();

            for (int i : nums1) {
                set.add(i);
            }

            Set<Integer> tmp = new HashSet<>();
            for (int i : nums2) {
                if (set.contains(i)) {
                    tmp.add(i);
                }
            }

            int[] res = new int[tmp.size()];
            int idx = 0;
            Iterator<Integer> iterator = tmp.iterator();
            while (iterator.hasNext()) {
                res[idx] = iterator.next();
                idx++;
            }
            return res;
        }
    }
}
