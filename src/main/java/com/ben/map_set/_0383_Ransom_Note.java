package com.ben.map_set;

public class _0383_Ransom_Note {

    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) {
                return false;
            }

            int[] map = new int[26];

            for (Character c : magazine.toCharArray()) {
                int key = c - 'a';
                map[key] = map[key] + 1;
            }

            for (Character c : ransomNote.toCharArray()) {
                int key = c - 'a';
                int val = map[key];
                if (val == 0) {
                    return false;
                }
                map[key] = val - 1;
            }

            return true;
        }
    }
}
