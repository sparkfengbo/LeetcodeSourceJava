import java.util.HashSet;
import java.util.Set;

public class LeetCode219 {

    public static void main(String[] args) {
        System.out.println();
    }

    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if (k == 0) {
                return false;
            }
            int len = nums.length;
            Set<Integer> set = new HashSet<>();
            //窗口大小   k+1长度
            k = Math.min(k, len - 1);
            for (int i = 0; i <= k; i++) {
                if (!set.add(nums[i])) {
                    return true;
                }
            }

            for (int i = k + 1; i < len; i++) {
                set.remove(nums[i - k - 1]);
                if (!set.add(nums[i])) {
                    return true;
                }
            }
            return false;
        }
    }

}
