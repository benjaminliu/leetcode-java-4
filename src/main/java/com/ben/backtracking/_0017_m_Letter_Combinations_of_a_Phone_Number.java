package com.ben.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class _0017_m_Letter_Combinations_of_a_Phone_Number {

    class Solution {
        private Map<Character, List<Character>> map = Map.ofEntries(
                Map.entry('2', List.of('a', 'b', 'c')),
                Map.entry('3', List.of('d', 'e', 'f')),
                Map.entry('4', List.of('g', 'h', 'i')),
                Map.entry('5', List.of('j', 'k', 'l')),
                Map.entry('6', List.of('m', 'n', 'o')),
                Map.entry('7', List.of('p', 'q', 'r', 's')),
                Map.entry('8', List.of('t', 'u', 'v')),
                Map.entry('9', List.of('w', 'x', 'y', 'z'))
        );

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits.length() == 0) {
                return res;
            }
            helper(digits, 0, new StringBuilder(), res);
            return res;
        }

        private void helper(String digits, int idx, StringBuilder sb, List<String> res) {
            if (digits.length() == idx) {
                res.add(sb.toString());
                return;
            }

            for (Character c : map.get(digits.charAt(idx))) {
                sb.append(c);
                helper(digits, idx + 1, sb, res);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}
