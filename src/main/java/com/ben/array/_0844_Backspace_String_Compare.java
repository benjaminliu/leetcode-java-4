package com.ben.array;

import com.ben.util.PrintUtil;

public class _0844_Backspace_String_Compare {
    public static void main(String[] args) {
        PrintUtil.printLn(new Solution().backspaceCompare("nzp#o#g",
                "b#nzp#o#g"));
    }

    static class Solution {

        public boolean backspaceCompare(String s, String t) {
            int idxS = s.length() - 1;
            int idxT = t.length() - 1;


            while (idxS >= 0 && idxT >= 0) {
                idxS = removeBackSpace(s, idxS);

                if (idxS == -1) {
                    break;
                }

                idxT = removeBackSpace(t, idxT);

                if (idxT == -1) {
                    break;
                }

                if (s.charAt(idxS) != t.charAt(idxT)) {
                    return false;
                }

                idxS--;
                idxT--;
            }

            if (idxS >= 0) {
                idxS = removeBackSpace(s, idxS);
            }

            if (idxT >= 0) {
                idxT = removeBackSpace(t, idxT);
            }

            return idxS == idxT;
        }

        private int removeBackSpace(String str, int idx) {
            int backspaceCount = 0;

            while (idx >= 0 && (str.charAt(idx) == '#' || backspaceCount > 0)) {
                if (str.charAt(idx) == '#') {
                    backspaceCount++;
                } else {
                    backspaceCount--;
                }
                idx--;
            }

            return idx;
        }
    }
}
