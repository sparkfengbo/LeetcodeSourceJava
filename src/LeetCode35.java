import java.util.*;

public class LeetCode35 {

    public static void main(String[] args) {
        System.out.print("");
    }


    public int searchInsert(int[] nums, int target) {
        int n = nums.length;

        int l = 0, r = n;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }
}
