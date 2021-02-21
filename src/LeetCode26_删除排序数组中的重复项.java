import datastruct.ListNode;

public class LeetCode26_删除排序数组中的重复项 {

    public static void main(String[] args) {
        removeDuplicates(new int[]{1, 1});
        System.out.print("");
    }


    /**
     * 双指针
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        int step = 1;
        if (nums.length <= step) {
            return nums.length;
        }

        int left = step;
        for (int right = step; right < nums.length; right++) {
            if (nums[right] != nums[left - step]) {
                nums[left++] = nums[right];
            }
        }
        return left;
    }
}
