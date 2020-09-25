import java.util.Arrays;

public class LeetCode280 {

    public static void main(String[] args) {
        int[] test = new int[]{3, 5, 2, 1, 6, 4};
        wiggleSort(test);
    }

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void wiggleSort2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean less = i % 2 == 0;
            if (less) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

}
