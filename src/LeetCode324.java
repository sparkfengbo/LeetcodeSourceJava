
public class LeetCode324 {
    public static void main(String[] args) {
        int[] test = new int[]{3,5,2,1,6,4};
        test = new int[]{4,5,5,6};
        wiggleSort2(test);
    }
    public static void wiggleSort(int[] nums) {

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void wiggleSort2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean less = i % 2 == 0;

            int next = i + 1;
            while (next < nums.length && nums[i] == nums[next]) {
                next++;
            }
            if (next > i + 1) {
                swap(nums, i+1, next);
            }

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
