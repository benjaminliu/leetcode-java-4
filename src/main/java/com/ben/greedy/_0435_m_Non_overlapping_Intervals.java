package com.ben.greedy;

import java.util.Arrays;

public class _0435_m_Non_overlapping_Intervals {

    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                // sort by right edge
                return Integer.compare(a[1], b[1]);
            });

            int count = 0;
            int lastIntervalRightEdge = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                int currentIntervalLeftEdge = intervals[i][0];
                //no overlap
                if (lastIntervalRightEdge <= currentIntervalLeftEdge) {
                    lastIntervalRightEdge = intervals[i][1];
                } else {
                    //has overlap
                    count++;
                }
            }

            return count;
        }
    }

    class Solution2 {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                // sort by right edge
                return Integer.compare(a[1], b[1]);
            });

            int count = 1;

            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] >= intervals[i - 1][1]) {
                    count++;
                } else {
                    intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
                }
            }

            return intervals.length - count;
        }
    }
}
