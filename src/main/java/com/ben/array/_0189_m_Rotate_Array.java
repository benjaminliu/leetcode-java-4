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

    class Solution1 {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        void reverse(int[] nums, int left, int right) {
            for (int i = left, j = right; i < j; i++, j--) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }

        void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
}
