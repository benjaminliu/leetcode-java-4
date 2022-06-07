package com.ben.greedy;

import java.util.stream.IntStream;

public class _0135_h_Candy {

    class Solution {
        public int candy(int[] ratings) {
            int[] candys = new int[ratings.length];
            candys[0] = 1;
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candys[i] = candys[i - 1] + 1;
                } else {
                    //choose min value
                    candys[i] = 1;
                }
            }


            for (int i = ratings.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candys[i] = Math.max(candys[i], candys[i + 1] + 1);
                }
            }

            return IntStream.of(candys).sum();
        }
    }
}
