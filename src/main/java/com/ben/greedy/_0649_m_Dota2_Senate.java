package com.ben.greedy;

import com.ben.util.PrintUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _0649_m_Dota2_Senate {

    public static void main(String[] args) {
        String senate = "RRR";

        PrintUtil.printLn(new Solution().predictPartyVictory(senate));
    }

    public static class Solution {

        private static final char Radiant = 'R';
        private static final char Dire = 'D';

        private static Map<Character, String> map = new HashMap<>();

        static {
            map.put(Radiant, "Radiant");
            map.put(Dire, "Dire");
        }

        public String predictPartyVictory(String senate) {
            if (senate.length() < 3) {
                return map.get(senate.charAt(0));
            }

            Queue<Character> queue = new LinkedList<>();
            int totalRCount = 0;
            int totalDCount = 0;
            int rCount = 0;
            int dCount = 0;
            queue.offer(senate.charAt(0));

            if (queue.peek() == Radiant) {
                rCount++;
                totalRCount++;
            } else {
                dCount++;
                totalDCount++;
            }

            for (int i = 1; i < senate.length(); i++) {
                char cur = senate.charAt(i);
                if (cur == Radiant) {
                    if (dCount > 0) {
                        dCount--;
                    } else {
                        queue.offer(cur);
                        rCount++;
                        totalRCount++;
                    }
                } else {
                    if (rCount > 0) {
                        rCount--;
                    } else {
                        queue.offer(cur);
                        dCount++;
                        totalDCount++;
                    }
                }
            }

            while (queue.size() > 1 && totalDCount > 0 && totalRCount > 0) {
                totalDCount = 0;
                totalRCount = 0;
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    char cur = queue.poll();
                    if (cur == Radiant) {
                        if (dCount > 0) {
                            dCount--;
                        } else {
                            queue.offer(cur);
                            rCount++;
                            totalRCount++;
                        }
                    } else {
                        if (rCount > 0) {
                            rCount--;
                        } else {
                            queue.offer(cur);
                            dCount++;
                            totalDCount++;
                        }
                    }
                }
            }

            return map.get(queue.peek());
        }
    }

    public static class Solution1 {

        private static final char Radiant = 'R';
        private static final char Dire = 'D';

        private static Map<Character, String> map = new HashMap<>();

        static {
            map.put(Radiant, "Radiant");
            map.put(Dire, "Dire");
        }

        public String predictPartyVictory(String senate) {
            if (senate.length() < 3) {
                return map.get(senate.charAt(0));
            }
            Queue<Integer> queueR = new LinkedList<>();
            Queue<Integer> queueD = new LinkedList<>();
            for (int i = 0; i < senate.length(); i++) {
                if (senate.charAt(i) == Radiant) {
                    queueR.offer(i);
                } else {
                    queueD.offer(i);
                }
            }

            int newIdx = senate.length();
            while (!queueR.isEmpty() && !queueD.isEmpty()) {
                int idxR = queueR.poll();
                int idxD = queueD.poll();

                //whichever senate vote first, he has a chance to vote again.
                if (idxR < idxD) {
                    queueR.add(newIdx);
                } else {
                    queueD.add(newIdx);
                }
                newIdx++;
            }
            return queueR.isEmpty() ? "Dire" : "Radiant";
        }
    }
}
