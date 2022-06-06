package com.ben.greedy;

import java.util.stream.IntStream;

public class _0134_m_Gas_Station {

    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {

            int start = 0;
            //Sum from start
            int curSum = 0;
            //Sum from index 0
            int totalSum = 0;


            for (int i = 0; i < gas.length; i++) {
                int rest = gas[i] - cost[i];

                curSum += rest;
                totalSum += rest;

                if (curSum < 0) {
                    start = i + 1;
                    curSum = 0;
                }
            }

            if (totalSum < 0) {
                return -1;
            }

            return start;
        }

    }
}
