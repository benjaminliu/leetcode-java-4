package com.ben.graph;

import java.util.*;

public class _0841_m_Keys_and_Rooms {

    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            Map<Integer, Boolean> map = new HashMap<>();

            Queue<List<Integer>> queue = new LinkedList<>();
            queue.offer(rooms.get(0));

            while (!queue.isEmpty()) {
                List<Integer> keys = queue.poll();
                for (Integer key : keys) {
                    //We can visit 0 anyway
                    if (key == 0) {
                        continue;
                    }
                    Boolean visited = map.getOrDefault(key, false);
                    if (!visited) {
                        queue.offer(rooms.get(key));
                        map.put(key, true);
                    }
                }
            }

            //beside 0, we need to visit other rooms
            return map.size() == rooms.size() - 1;
        }
    }
}
