package com.ben.map_set;

import com.ben.util.PrintUtil;

import java.util.*;

public class _0438_m_Find_All_Anagrams_in_a_String {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        PrintUtil.printList(new Solution().findAnagrams(s, p));
    }

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            Map<Character, Integer> map = new HashMap<>();
            for (Character c : p.toCharArray()) {
                increase(map, c);
            }

            Set<Character> set = new HashSet<>(map.keySet());
            Map<Character, Integer> temp = null;

            List<Integer> res = new ArrayList<>();

            int left = 0;
            int right = 0;
            while (right < s.length()) {
                Character c = s.charAt(right);
                if (!set.contains(c)) {
                    right++;
                    left = right;
                    continue;
                }

                if (left == right) {
                    temp = new HashMap<>(map);
                } else if (right - left < p.length()) {
                    //No special needs
                } else {
                    increase(temp, s.charAt(left));
                    left++;
                }

                if (!decrease(temp, c)) {
                    increase(temp, s.charAt(left));
                    left++;
                }
                right++;

                if (temp.size() == 0) {
                    res.add(left);
                }
            }

            return res;
        }

        private void increase(Map<Character, Integer> map, Character c) {
            int val = map.getOrDefault(c, 0);
            val++;
            if (val == 0) {
                map.remove(c);
            } else {
                map.put(c, val);
            }
        }

        private boolean decrease(Map<Character, Integer> map, Character c) {
            Integer val = map.getOrDefault(c, 0);
            val--;
            if (val == 0) {
                map.remove(c);
                return true;
            } else {
                map.put(c, val);
                if (val < 0) {
                    return false;
                }
                return true;
            }

        }
    }
}
