package com.ben.dp.pack;

import com.ben.util.PrintUtil;

public class _0_1_Pack {

    public static void main(String[] args) {
        int[] weight = new int[]{1, 3, 4};
        int[] value = new int[]{15, 20, 30};
        int bagSize = 4;

        PrintUtil.printLn(new Solution().weightBagProblem(weight, value, bagSize));
    }

    static class Solution {
        public int weightBagProblem(int[] weight, int[] value, int bagSize) {
            int row = weight.length;
            int col = bagSize + 1;

            int[][] dp = new int[row][col];

            //Put first item in the pack.
            for (int i = weight[0]; i < col; i++) {
                dp[0][i] = value[0];
            }

            for (int i = 1; i < weight.length; i++) {
                for (int j = 1; j < col; j++) {
                    int previousBiggestWeight = dp[i - 1][j];
                    if (j < weight[i]) {
                        //Can not put item i into pack, so current biggest weight is previous biggest weight
                        dp[i][j] = previousBiggestWeight;
                    } else {
                        //Can put item i into pack, need to check if put item i in the pack will make weight bigger
                        //In order to put item i into pack, we need to remove some weight from pack, that is [j-weight[i]]
                        int newTotalWeight = dp[i - 1][j - weight[i]] + value[i];
                        dp[i][j] = Math.max(previousBiggestWeight, newTotalWeight);
                    }
                }
            }

            PrintUtil.printArrayOfArray(dp);

            return dp[weight.length - 1][bagSize];
        }
    }
}
