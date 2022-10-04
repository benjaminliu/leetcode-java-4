package com.ben.string;

import com.ben.util.PrintUtil;

import java.util.Deque;
import java.util.LinkedList;

public class _0844_Backspace_String_Compare {

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        PrintUtil.printLn(new Solution().backspaceCompare(s, t));
    }

    static class Solution {
        private static final char sharp = '#';

        public boolean backspaceCompare(String s, String t) {
            Deque<Character> queueS = getQueue(s);
            Deque<Character> queueT = getQueue(t);

            while (!queueS.isEmpty() && !queueT.isEmpty()) {
                if (queueS.pop() != queueT.pop()) {
                    return false;
                }
            }
            if (!queueS.isEmpty() || !queueT.isEmpty()) {
                return false;
            }

            return true;
        }

        private Deque<Character> getQueue(String s) {
            Deque<Character> queue = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (c == sharp) {
                    if (!queue.isEmpty()) {
                        queue.pop();
                    }
                } else {
                    queue.push(c);
                }
            }
            return queue;
        }
    }


    class Solution1 {
        private static final char sharp = '#';

        public boolean backspaceCompare(String s, String t) {
            int idxS = s.length() - 1;
            int idxT = t.length() - 1;
            int skipS = 0;
            int skipT = 0;

            while (idxS >= 0 && idxT >= 0) {
                if (s.charAt(idxS) == sharp) {
                    skipS++;
                    idxS--;
                    continue;
                }
                if (skipS > 0) {
                    skipS--;
                    idxS--;
                    continue;
                }

                if (t.charAt(idxT) == sharp) {
                    skipT++;
                    idxT--;
                    continue;
                }
                if (skipT > 0) {
                    skipT--;
                    idxT--;
                    continue;
                }

                if (s.charAt(idxS) != t.charAt(idxT)) {
                    return false;
                }
                idxS--;
                idxT--;
            }

            while (idxS >= 0) {
                if (s.charAt(idxS) == sharp) {
                    skipS++;
                    idxS--;
                    continue;
                }
                if (skipS > 0) {
                    skipS--;
                    idxS--;
                    continue;
                }

                return false;
            }
            while (idxT >= 0) {
                if (t.charAt(idxT) == sharp) {
                    skipT++;
                    idxT--;
                    continue;
                }
                if (skipT > 0) {
                    skipT--;
                    idxT--;
                    continue;
                }
                return false;
            }
            return true;
        }
    }
}
