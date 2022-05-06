package 剑指Offer;

public class Offer21 {
    static class Solution {
        public int[] exchange(int[] nums) {
            int n = nums.length;
            int l = 0, r = n - 1;
            while (l < r) {
                while (l < r && ((nums[l] & 1) == 1)) {
                    l++;
                }

                while (l < r && ((nums[r] & 1) == 0)) {
                    r--;
                }

                if (l < r) {
                    swap(nums, l, r);
                    l++;
                    r--;
                }
            }
            return nums;
        }


        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.exchange(new int[]{1, 2, 3, 4});
    }


}
