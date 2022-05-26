package com.ben.greedy;

import java.util.Arrays;

public class _0455_Assign_Cookies {

    class Solution {
        public int findContentChildren(int[] g, int[] s) {

            int count = 0;
            boolean[] assigned = new boolean[s.length];
            for (int i = 0; i < g.length; i++) {
                Integer min = null;
                Integer minIdx = null;
                for (int j = 0; j < s.length; j++) {
                    if (assigned[j]) {
                        continue;
                    }

                    //can assign
                    if (s[j] >= g[i]) {
                        if (min == null) {
                            min = s[j];
                            minIdx = j;
                        } else {
                            if (s[j] < min) {
                                min = s[j];
                                minIdx = j;
                            }
                        }
                    }
                }
                if (min != null) {
                    assigned[minIdx] = true;
                    count++;
                }
            }

            return count;
        }
    }

    class Solution1 {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);

            int count = 0;
            int idx = 0;

            for (int i = 0; i < s.length && idx < g.length; i++) {
                if (s[i] >= g[idx]) {
                    count++;
                    idx++;
                }
            }
            return count;
        }
    }
}
