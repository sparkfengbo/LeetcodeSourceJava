import datastruct.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode215 {

    public static void main(String[] args) {

        System.out.println();
    }

    /**
     * 快排
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

//    public static int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];
//    }

}
