package 剑指Offer;

import java.util.Arrays;

public class Offer39 {

    class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }

    class Solution_1 {
        public int majorityElement(int[] nums) {
            quickSort(nums, 0, nums.length  - 1);
            return nums[nums.length / 2];
        }

        private void quickSort(int[] nums, int left, int right) {
            if (left < right) {
                int index = partition(nums, left, right);
                quickSort(nums, left, index - 1);
                quickSort(nums, index + 1, right);
            }
        }

        private int partition(int[] nums, int left, int right) {
            int i = left, j = right;
            while (i < j) {
                while (i < j && nums[j] >= nums[left]) {
                    j--;
                }
                while (i < j && nums[i] <= nums[left]) {
                    i++;
                }
                swap(nums, i, j);
            }
            swap(nums, i, left);
            return i;
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {

    }
}
