package com.ben.backtracking;

import com.ben.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class _0093_m_Restore_IP_Addresses {

    public static void main(String[] args) {
        PrintUtil.printList(new Solution().restoreIpAddresses("101023"));
    }

    static class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();

            helper(s, 0, 4, new StringBuilder(), res);

            return res;
        }

        private void helper(String s, int start, int segment, StringBuilder sb, List<String> res) {
            if (segment == 0) {
                if (start == s.length()) {
                    res.add(sb.toString().substring(1));
                }
                return;
            }

            int minCount = segment;
            int maxCount = 3 * segment;

            int count = s.length() - start;
            if (count < minCount || count > maxCount) {
                return;
            }

            for (int i = 1; i <= 3; i++) {
                Integer ipSegment = getIPSegment(s, start, start + i);

                if (ipSegment == null) {
                    continue;
                }

                int len = sb.length();
                sb.append(".").append(ipSegment);
                helper(s, start + i, segment - 1, sb, res);
                sb.setLength(len);
            }
        }

        private Integer getIPSegment(String s, int start, int end) {
            if (end <= s.length()) {
                String tmp = s.substring(start, end);
                if (tmp.length() > 1 && tmp.charAt(0) == '0') {
                    return null;
                }
                int no = Integer.parseInt(tmp);
                if (no < 256) {
                    return no;
                }
            }
            return null;
        }
    }
}
