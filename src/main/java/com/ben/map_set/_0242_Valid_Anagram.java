package com.ben.map_set;

import java.util.HashMap;
import java.util.Map;

public class _0242_Valid_Anagram {

    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            Map<Character, Integer> map = new HashMap<>();

            for (Character cs : s.toCharArray()) {
                Integer val = map.getOrDefault(cs, 0);
                map.put(cs, val + 1);
            }

            for (Character ct : t.toCharArray()) {
                Integer val = map.getOrDefault(ct, 0);
                if (val == 0) {
                    return false;
                } else if (val == 1) {
                    map.remove(ct);
                } else {
                    map.put(ct, val - 1);
                }
            }

            return map.size() == 0;
        }
    }

    class Solution2 {
        public boolean isAnagram(String s, String t) {
            int[] map = new int[26];
            for (Character cs : s.toCharArray()) {
                int key = cs - 'a';
                map[key] = map[key] + 1;
            }
            for (Character ct : t.toCharArray()) {
                int key = ct - 'a';
                int val = map[key];
                if (val == 0) {
                    return false;
                }
                map[key] = val - 1;
            }

            for(int i : map){
                if(i != 0){
                    return false;
                }
            }
            return true;
        }
    }
}
