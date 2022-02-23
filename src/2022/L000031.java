import datastruct.ListNode;

public class L000031 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
    }

    public static void nextPermutation(int[] nums) {

        //1. 从后向前，找到第一个升序变成降序的index
        int index = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                index = i - 1;
                break;
            }
        }


        if (index >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[index]) {
                j--;
            }
            swap(nums, index, j);
        }

        reverse(nums, index + 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
