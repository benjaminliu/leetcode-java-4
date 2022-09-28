package com.ben.array;

import com.ben.util.PrintUtil;

public class _0922_Sort_Array_By_Parity_II {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 5, 7};
        PrintUtil.printArray(new Solution().sortArrayByParityII(nums));
    }

    static class Solution {
        public int[] sortArrayByParityII(int[] nums) {

            int cur = 0;
            while (cur < nums.length) {
                if (isEven(cur)) {
                    //even
                    if (!isEven(nums[cur])) {
                        int toSwap = cur + 1;
                        while (!isEven(nums[toSwap])) {
                            toSwap++;
                        }
                        swap(nums, cur, toSwap);

                    }
                } else {
                    //odd
                    if (isEven(nums[cur])) {
                        int toSwap = cur + 1;
                        while (isEven(nums[toSwap])) {
                            toSwap++;
                        }
                        swap(nums, cur, toSwap);
                    }
                }
                cur++;
            }

            return nums;
        }

        private boolean isEven(int a) {
            return a % 2 == 0;
        }

        private void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
}
