package com.ben.others.interview;

import com.ben.util.PrintUtil;

import java.util.*;

public class CanDecode {

    public static void main(String[] args) {
//        Set<String> dict = Set.of("$a", "#", "@@c", "d", "c");
//        String str = "$a#@@cc";

        Set<String> dict = Set.of("$a", "#", "@@c", "d", "c");
        String str = "$a#@@d";

        PrintUtil.printLn(new Solution().canDecode(str, dict));
    }

    // In World War II, we to decode a message sent from our enmey, however,
    // sometimes the enemy would transimit jerbrish messages in order to confuse us.
    // Your job is to determine whether the message can be decoded.
    // Now given a message string and a dictionary containing encryption tokens,
    // determine whether it's possible to decode the message string into
    // a sequence of space-delimiated encryption tokens.

    // For example, message = "$a#@@cc", dictionary = ["$a", "#", "@@c", "d", "c"]
    // The message can be segemented into: "$a # @@c c", so your program should return True

    // Another example, message = "$a#@@d", dictionary = ["$a", "#", "@@c", "d", "c"].
    // The message cannot be segemented into the encryption tokens, thus your program should return False

    // Follow up: can you return all the possible sentences where each token is valid.
    // '''

    static class Solution {
        public boolean canDecode(String str, Set<String> dict) {
            Map<Character, List<Integer>> initialToLengthMap = createMap(dict);

            return backTracking(str, initialToLengthMap, dict, 0);
        }

        private static boolean backTracking(String str, Map<Character, List<Integer>> map, Set<String> dict, int idx) {
            if (idx == str.length()) {
                return true;
            }
            char cur = str.charAt(idx);
            List<Integer> tokenLengthList = map.get(cur);
            if (tokenLengthList == null) {
                return false;
            }

            for (int length : tokenLengthList) {
                int endIdx = idx + length;
                if (endIdx > str.length()) {
                    continue;
                }
                String token = str.substring(idx, endIdx);
                if (!dict.contains(token)) {
                    continue;
                }

                if (backTracking(str, map, dict, idx + length)) {
                    return true;
                }
            }

            return false;
        }

        private static Map<Character, List<Integer>> createMap(Set<String> dict) {
            Map<Character, List<Integer>> initialToLengthMap = new HashMap<>();
            for (String s : dict) {
                char key = s.charAt(0);
                List<Integer> lengths = initialToLengthMap.getOrDefault(key, new ArrayList<>());
                lengths.add(s.length());
                initialToLengthMap.put(key, lengths);
            }
            return initialToLengthMap;
        }
    }
}
