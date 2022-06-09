package com.ben.greedy;

import java.util.TreeMap;

public class _0860_Lemonade_Change {

    class Solution {
        public boolean lemonadeChange(int[] bills) {
            if (bills[0] != 5) {
                return false;
            }

            int money5Count = 1;
            int money10Count = 0;

            for (int i = 1; i < bills.length; i++) {
                int money = bills[i];
                if (money == 5) {
                    money5Count++;
                } else if (money == 10) {
                    if (money5Count == 0) {
                        return false;
                    }

                    money5Count--;
                    money10Count++;
                } else {
                    //20
                    if (money10Count > 0 && money5Count > 0) {
                        money10Count--;
                        money5Count--;
                    } else if (money5Count >= 3) {
                        money5Count -= 3;
                    } else {
                        return false;
                    }
                }
            }

            return true;
        }


    }
}
