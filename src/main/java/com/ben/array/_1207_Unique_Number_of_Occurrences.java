package com.ben.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1207_Unique_Number_of_Occurrences {

    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                Integer count = map.getOrDefault(arr[i], 0);
                map.put(arr[i], count + 1);
            }

            Set<Integer> set = new HashSet<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (!set.add(entry.getValue())) {
                    return false;
                }
            }
            return true;
        }
    }
}
