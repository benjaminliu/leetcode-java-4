package com.ben.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _0131_m_Palindrome_Partitioning {

    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();

            helper(s, 0, new ArrayList<String>(), res);

            return res;
        }

        private void helper(String s, int start, ArrayList<String> group, List<List<String>> res) {
            if (start == s.length()) {
                res.add(new ArrayList<>(group));
                return;
            }
            int left = start;
            for (int right = start; right < s.length(); right++) {
                if (!isPalindrome(s, left, right)) {
                    continue;
                }

                group.add(s.substring(left, right + 1));
                helper(s, right + 1, group, res);
                group.remove(group.size() - 1);
            }
        }

        private boolean isPalindrome(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }


    }
}
