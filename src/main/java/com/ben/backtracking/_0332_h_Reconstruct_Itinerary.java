package com.ben.backtracking;

import java.util.*;

public class _0332_h_Reconstruct_Itinerary {

    class Solution {
        public List<String> findItinerary(List<List<String>> tickets) {
            Map<String, Map<String, Integer>> map = new HashMap<>();
            List<String> res = new ArrayList<>();

            for (List<String> t : tickets) {
                Map<String, Integer> tmp = map.get(t.get(0));
                if (tmp == null) {
                    tmp = new TreeMap<>();
                    map.put(t.get(0), tmp);
                }
                Integer val = tmp.getOrDefault(t.get(1), 0);
                tmp.put(t.get(1), val + 1);
            }

            res.add("JFK");

            helper(tickets.size(), map, res);

            return res;
        }

        private boolean helper(int size, Map<String, Map<String, Integer>> map, List<String> res) {
            if (res.size() == size + 1) {
                return true;
            }

            String last = res.get(res.size() - 1);
            Map<String, Integer> tmp = map.get(last);

            if (tmp != null) {
                for (Map.Entry<String, Integer> entry : tmp.entrySet()) {
                    int count = entry.getValue();
                    if (count > 0) {
                        res.add(entry.getKey());
                        entry.setValue(count - 1);
                        if (helper(size, map, res)) {
                            return true;
                        }
                        res.remove(res.size() - 1);
                        entry.setValue(count);
                    }
                }
            }
            return false;
        }
    }
}
