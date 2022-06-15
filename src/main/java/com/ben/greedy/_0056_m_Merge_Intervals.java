package com.ben.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0056_m_Merge_Intervals {
    class Solution {
        public int[][] merge(int[][] intervals) {

            Arrays.sort(intervals, (a, b) -> {
                return Integer.compare(a[0], b[0]);
            });

            List<int[]> res = new ArrayList<>();
            int[] cur = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                int[] tmp = intervals[i];
                if (tmp[0] <= cur[1]) {
                    cur[1] = Math.max(cur[1], tmp[1]);
                } else {
                    res.add(cur);
                    cur = tmp;
                }
            }
            res.add(cur);

            return res.toArray(new int[0][0]);
        }
    }
}
