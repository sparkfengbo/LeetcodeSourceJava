import utils.Utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode128 {

    public static int longestConsecutive(int[] nums) {
        int N = nums.length;
        if (N <= 1) {
            return N;
        }

        Set<Integer> cache = new HashSet<>();
        for (int n : nums) {
            cache.add(n);
        }

        int ans = 1;
        for (int n : nums) {
            if (!cache.contains(n - 1)) {
                int currentN = n;
                int currentAns = 1;

                while (cache.contains(currentN + 1)) {
                    currentN += 1;
                    currentAns += 1;
                }
                ans = Math.max(ans, currentAns);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
