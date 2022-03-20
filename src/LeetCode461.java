import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LeetCode461 {

    public static void main(String[] args) {

    }


    class Solution {
        public int totalHammingDistance(int[] nums) {
            int ans = 0, n = nums.length;
            for (int i = 0; i < 30; ++i) {
                int c = 0;
                for (int val : nums) {
                    c += (val >> i) & 1;
                }
                ans += c * (n - c);
            }
            return ans;
        }
    }

}
