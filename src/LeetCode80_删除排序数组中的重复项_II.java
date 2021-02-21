public class LeetCode80_删除排序数组中的重复项_II {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;

        int l = 1, count = 1;
        for (int r = 2; r < nums.length; r++){
            if (nums[r] == nums[r - 1]) {
                count += 1;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[l++] = nums[r];
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates(test));
        System.out.println(removeDuplicates2(test));
    }

    public static int removeDuplicates2(int[] nums) {
        int step = 2;
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
