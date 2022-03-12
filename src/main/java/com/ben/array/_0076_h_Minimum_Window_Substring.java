package com.ben.array;

import com.ben.util.PrintUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _0076_h_Minimum_Window_Substring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        PrintUtil.printLn(new Solution().minWindow(s, t));
    }

    static class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> map = getCharCount(t);

            int start = 0;
            int end = 0;

            int minStart = 0;
            int minLen = s.length() + 1;

            int count = t.length();

            while (end < s.length()) {
                char toAdd = s.charAt(end);
                Integer toAddCount = map.getOrDefault(toAdd, 0);
                if (toAddCount > 0) {
                    count--;
                }
                map.put(toAdd, toAddCount - 1);

                while (count == 0) {
                    int len = end - start + 1;
                    if (len < minLen) {
                        minLen = len;
                        minStart = start;
                    }

                    char toRemove = s.charAt(start);
                    map.put(toRemove, map.getOrDefault(toRemove, 0) + 1);
                    if (map.get(toRemove) > 0) {
                        count++;
                    }
                    start++;
                }
                end++;
            }

            if (minLen > s.length()) {
                return "";
            }

            return s.substring(minStart, minStart + minLen);
        }


        private Map<Character, Integer> getCharCount(String t) {
            Map<Character, Integer> res = new HashMap<>();
            for (char c : t.toCharArray()) {
                add(res, c);
            }
            return res;
        }

        private void add(Map<Character, Integer> map, char key) {
            int val = map.getOrDefault(key, 0);
            val++;
            map.put(key, val);
        }
    }
}
