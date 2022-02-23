public class L000033 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};

        System.out.println(search(arr, 2));
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > nums[left]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return -1;
    }
}
