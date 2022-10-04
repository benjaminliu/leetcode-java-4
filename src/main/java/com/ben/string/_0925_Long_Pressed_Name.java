package com.ben.string;

public class _0925_Long_Pressed_Name {

    class Solution {
        public boolean isLongPressedName(String name, String typed) {
            if (typed.length() < name.length()) {
                return false;
            }

            int idxN = 0;
            int idxT = 0;
            while (idxN < name.length() && idxT < typed.length()) {
                if (name.charAt(idxN) == typed.charAt(idxT)) {
                    idxN++;
                    idxT++;
                    continue;
                }
                if (idxT > 0 && typed.charAt(idxT) == typed.charAt(idxT - 1)) {
                    idxT++;
                    continue;
                }
                return false;
            }

            while (idxT != typed.length()) {
                if (typed.charAt(idxT) != typed.charAt(idxT - 1)) {
                    return false;
                }
                idxT++;
            }

            if (idxN != name.length() || idxT != typed.length()) {
                return false;
            }
            return true;
        }
    }
}
