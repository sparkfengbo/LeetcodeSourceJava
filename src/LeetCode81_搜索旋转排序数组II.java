public class LeetCode81_搜索旋转排序数组II {

    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] < target && target <= nums[right - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test = new int[]{ 7,7,7,1,2,3,4};
        System.out.println(search(test, 7));
    }
}
