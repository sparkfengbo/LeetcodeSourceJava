import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LeetCode704 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{-1, 0, 3, 5, 9, 12 },9));

    }

    static class Solution {
        public int search(int[] nums, int target) {
            int l = nums.length;
            if (l == 0) {
                return -1;
            }

            int left = 0, right = l;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }

}
