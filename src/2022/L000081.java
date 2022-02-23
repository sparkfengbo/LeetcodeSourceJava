public class L000081 extends Template {

    public static void main(String[] args) {

    }

    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[left] == nums[mid] && nums[right - 1] == nums[mid]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
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
        return false;
    }
}
