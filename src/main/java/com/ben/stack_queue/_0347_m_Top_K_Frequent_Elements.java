package com.ben.stack_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _0347_m_Top_K_Frequent_Elements {

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums) {
                Integer val = map.getOrDefault(i, 0);
                map.put(i, val + 1);
            }

            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> a.getValue() - b.getValue());
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                pq.offer(entry);
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            int[] res = new int[k];
            int idx = 0;
            while (!pq.isEmpty()) {
                res[idx] = pq.poll().getKey();
                idx++;
            }

            return res;
        }
    }
}
