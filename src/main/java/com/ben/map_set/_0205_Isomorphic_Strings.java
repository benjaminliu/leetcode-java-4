package com.ben.map_set;

import java.util.HashMap;
import java.util.Map;

public class _0205_Isomorphic_Strings {

    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            Map<Character, Character> mapS = new HashMap<>();
            Map<Character, Character> mapT = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char charS = s.charAt(i);
                char charT = t.charAt(i);
                if (!mapS.containsKey(charS)) {
                    mapS.put(charS, charT);
                }

                if (!mapT.containsKey(charT)) {
                    mapT.put(charT, charS);
                }

                if (mapS.get(charS) != charT || mapT.get(charT) != charS) {
                    return false;
                }
            }

            return true;
        }
    }


    public class Solution1 {
        public boolean isIsomorphic(String s1, String s2) {
            int[] m1 = new int[256];
            int[] m2 = new int[256];
            for (int i = 0; i < s1.length(); i++) {
                if (m1[s1.charAt(i)] != m2[s2.charAt(i)]) {
                    return false;
                }
                //Store last seen position
                //cannot start with 0, because default int is 0
                m1[s1.charAt(i)] = i + 1;
                m2[s2.charAt(i)] = i + 1;
            }
            return true;
        }
    }

}
