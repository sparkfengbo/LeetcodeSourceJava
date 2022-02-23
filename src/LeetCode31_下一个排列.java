import utils.Utils;

public class LeetCode31_下一个排列 {

    public static void main(String[] args) {
        System.out.print("");

        int[] test = new int[]{3,2,1};
        nextPermutation(test);

        for (int item : test) {
            System.out.print(item);
        }
        System.out.println();
    }

    /**
     * 可参考  https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //从后往前 升序中找到第一个降序
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            //上次查找的节点，找 最接近的那一个
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
