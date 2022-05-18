package 剑指Offer;

import com.sun.tools.javadoc.Start;

import java.util.HashMap;
import java.util.Map;

public class Offer57 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    return new int[]{map.get(nums[i]), nums[i]};
                } else {
                    map.put(target - nums[i], nums[i]);
                }
            }

            return new int[]{};
        }

        public int[] twoSum_(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int s = nums[left] + nums[right];
                if (s == target) {
                    return new int[]{nums[left], nums[right]};
                } else if (s > target) {
                    right--;
                } else {
                    left++;
                }
            }
            return new int[]{};
        }
    }

    public static void main(String[] args) {

    }


}
