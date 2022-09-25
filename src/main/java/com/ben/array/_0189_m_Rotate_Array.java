package com.ben.array;

public class _0189_m_Rotate_Array {

    class Solution {
        public void rotate(int[] nums, int k) {
            if (nums.length == 1 || k == 0) {
                return;
            }
            k = k % nums.length;

            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }

            left = 0;
            right = k - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
            left = k;
            right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
}
