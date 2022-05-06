public class LeetCode154 {

    class Solution {
        public int minArray(int[] numbers) {
            int n = numbers.length;
            int l = 0, r = n - 1;
            while (l < r) {
                int mid =  l + (r - l) / 2;
                if (numbers[mid] < numbers[r]) {
                    r = mid;
                } else if (numbers[mid] > numbers[r]) {
                    l = mid + 1;
                } else {
                    r --;
                }
            }
            return numbers[l];
        }
    }
    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int l = 0, r = nums.length - 1;

        if (nums[r] > nums[0]) {
            return nums[0];
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = new int[]{3,4,5,1,2};
//        System.out.println(findMin(test));
//        test = new int[]{4,5,6,7,0,1,2};
//        System.out.println(findMin(test));
        test = new int[]{2,3,4,5,1};
        System.out.println(findMin(test));
    }
}
