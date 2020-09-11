import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.Utils.printNestList;

public class LeetCode162 {

    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        return binarySearch(nums, 0, n - 1);
    }

    private static int binarySearch(int[] nums, int left, int right) {
        if (left == right)
            return left;

        int mid = (left + right) / 2;

        if (nums[mid] > nums[mid + 1]) {
            return binarySearch(nums, left, mid);
        } else {
            return binarySearch(nums, mid + 1, right);
        }
    }

    public int findPeakElement2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
         Utils.println(findPeakElement(new int[]{1,2,3,1}));
        Utils.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
