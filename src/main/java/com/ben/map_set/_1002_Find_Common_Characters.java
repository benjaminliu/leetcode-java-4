package com.ben.map_set;

import java.util.ArrayList;
import java.util.List;

public class _1002_Find_Common_Characters {

    class Solution {
        public List<String> commonChars(String[] words) {
            if (words.length == 0) {
                return new ArrayList<>(0);
            }

            int[] map = new int[26];

            for (Character c : words[0].toCharArray()) {
                map[c2I(c)]++;
            }

            for (int i = 1; i < words.length; i++) {
                int[] tmp = new int[26];
                for (Character c : words[i].toCharArray()) {
                    tmp[c2I(c)]++;
                }

                for (int j = 0; j < map.length; j++) {
                    map[j] = Math.min(map[j], tmp[j]);
                }
            }

            List<String> res = new ArrayList<>();
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i]; j++) {
                    res.add(String.valueOf(i2c(i)));
                }
            }

            return res;
        }

        private int c2I(Character c) {
            return c - 'a';
        }

        private Character i2c(int i) {
            return (char) (i + 'a');
        }
    }
}
