package com.ben.others.bits;

import com.ben.util.PrintUtil;

import java.util.*;
import java.util.stream.IntStream;

public class _1356_Sort_Integers_by_The_Number_of_1_Bits {

    public static void main(String[] args) {

        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        PrintUtil.printArray(new Solution().sortByBits(arr));
    }

    class Solution {

        private int cntInt(int val) {
            int count = 0;
            while (val > 0) {
                val = val & (val - 1);
                count++;
            }

            return count;
        }

        public int[] sortByBits(int[] arr) {
            return IntStream.of(arr)
                    .boxed()
                    .sorted(new Comparator<Integer>() {

                        @Override
                        public int compare(Integer o1, Integer o2) {
                            int cnt1 = Integer.bitCount(o1);
                            int cnt2 = Integer.bitCount(o2);

                            return (cnt1 == cnt2) ?
                                    Integer.compare(o1, o2) :
                                    Integer.compare(cnt1, cnt2);
                        }
                    })
                    .mapToInt(Integer::intValue)
                    .toArray();
        }


    }
}
