package com.ben.greedy;

import com.ben.util.PrintUtil;

import java.util.*;

public class _0763_m_Partition_Labels {

    public static void main(String[] args) {
        PrintUtil.printList(new Solution().partitionLabels("ababcbacadefegdehijhklij"));
    }

    static class Solution {
        public List<Integer> partitionLabels(String s) {
            Map<Character, int[]> map = new HashMap<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char key = chars[i];
                int[] range = map.get(key);
                if (range == null) {
                    range = new int[]{i, i};
                } else {
                    range[1] = i;
                }

                map.put(key, range);
            }

            int[][] ranges = new int[map.size()][];
            int index = 0;
            for (int[] range : map.values()) {
                ranges[index] = range;
                index++;
            }

            Arrays.sort(ranges, (a, b) -> {
                return Integer.compare(a[0], b[0]);
            });

            List<Integer> res = new ArrayList<>();
            int left = ranges[0][0];
            for (int i = 1; i < ranges.length; i++) {
                if (ranges[i][0] > ranges[i - 1][1]) {
                    res.add(ranges[i - 1][1] - left + 1);
                    left = ranges[i][0];
                } else {
                    ranges[i][1] = Math.max(ranges[i - 1][1], ranges[i][1]);
                }
            }
            res.add(s.length() - left);

            return res;
        }
    }


    static class Solution2 {
        public List<Integer> partitionLabels(String s) {
            //统计每个字符的最右边的位置
            int[] rightEdges = new int[26];
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                rightEdges[chars[i] - 'a'] = i;
            }

            int idx = 0;
            int last = -1;
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                idx = Math.max(idx, rightEdges[chars[i] - 'a']);
                //到了最右边的地方了
                if (i == idx) {
                    res.add(i - last);
                    last = i;
                }
            }
            return res;
        }
    }
}
