public class L000026 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};

        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int left = 1;
        for (int right = 1; right < nums.length; right++) {
            if (nums[left - 1] != nums[right]) {
                nums[left] = nums[right];
                ++left;
            }
        }
        return left;
    }
}
