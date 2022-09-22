package com.ben.array;

public class _0941_Valid_Mountain_Array {

    class Solution {
        public boolean validMountainArray(int[] arr) {
            if (arr.length < 3) {
                return false;
            }
            if (arr[1] <= arr[0]) {
                return false;
            }

            boolean reachTop = false;

            for (int i = 2; i < arr.length; i++) {
                if (arr[i] == arr[i - 1]) {
                    return false;
                }

                if (reachTop == false) {
                    if (arr[i] < arr[i - 1]) {
                        reachTop = true;
                    }
                } else {
                    if (arr[i] > arr[i - 1]) {
                        return false;
                    }
                }
            }
            if (reachTop == false) {
                return false;
            }
            return true;
        }
    }


    class Solution1 {
        public boolean validMountainArray(int[] arr) {
            if (arr.length < 3) {
                return false;
            }

            int left = 0;
            while (left < arr.length - 1 && arr[left] < arr[left + 1]) {
                left++;
            }
            if (left == 0) {
                return false;
            }
            int right = arr.length - 1;
            while (right > 0 && arr[right - 1] > arr[right]) {
                right--;
            }
            if (right == arr.length - 1) {
                return false;
            }
            return left == right;
        }
    }
}
