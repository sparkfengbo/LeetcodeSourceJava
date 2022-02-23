import datastruct.ListNode;

import java.util.HashMap;
import java.util.Map;

public class L002006 extends Template {

    public static void main(String[] args) {
        System.out.println(countKDifference(new int[]{1, 2, 2, 1}, 1));
        System.out.println(countKDifference(new int[]{1, 3}, 3));
        System.out.println(countKDifference(new int[]{3, 2, 1, 5, 4}, 2));
        System.out.println(countKDifference(new int[]{9, 3, 1, 1, 4, 5, 4, 9, 5, 10}, 1));
    }

    public static int countKDifference(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count += map.getOrDefault(nums[i] + k, 0) + map.getOrDefault(nums[i] - k, 0) ;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return count;
    }
}
