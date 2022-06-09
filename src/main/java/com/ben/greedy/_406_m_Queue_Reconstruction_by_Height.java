package com.ben.greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class _406_m_Queue_Reconstruction_by_Height {

    class Solution {
        public int[][] reconstructQueue(int[][] people) {

            // 身高从大到小排（身高相同k小的站前面）
            Arrays.sort(people, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            });

            LinkedList<int[]> queue = new LinkedList<>();
            for (int[] p : people) {
                queue.add(p[1], p);
            }

            return queue.toArray(new int[people.length][]);
        }
    }
}
