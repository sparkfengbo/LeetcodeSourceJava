import java.util.*;

public class LeetCode220_存在重复元素III {

    public static void main(String[] args) {
        System.out.println();
    }


//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/contains-duplicate-iii/solution/cun-zai-zhong-fu-yuan-su-iii-by-leetcode-bbkt/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int n = nums.length;
            TreeSet<Long> set = new TreeSet<Long>();
            for (int i = 0; i < n; i++) {
                Long ceiling = set.ceiling((long) nums[i] - (long) t);
                if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                    return true;
                }
                set.add((long) nums[i]);
                if (i >= k) {
                    set.remove((long) nums[i - k]);
                }
            }
            return false;
        }
    }

    class Solution_ {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int n = nums.length;
            Map<Long, Long> map = new HashMap<Long, Long>();
            long w = (long) t + 1;
            for (int i = 0; i < n; i++) {
                long id = getID(nums[i], w);
                if (map.containsKey(id)) {
                    return true;
                }
                if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
                    return true;
                }
                if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                    return true;
                }
                map.put(id, (long) nums[i]);
                if (i >= k) {
                    map.remove(getID(nums[i - k], w));
                }
            }
            return false;
        }

        public long getID(long x, long w) {
            if (x >= 0) {
                return x / w;
            }
            return (x + 1) / w - 1;
        }
    }


}
