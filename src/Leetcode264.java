import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Leetcode264 {
    class Solution {
        public int nthUglyNumber(int n) {
            if (n <= 6) {
                return n;
            }
            int[] factors = {2, 3, 5};
            Set<Long> seen = new HashSet<>();
            PriorityQueue<Long> heap = new PriorityQueue<>();
            seen.add(1L);
            heap.offer(1L);
            int ugly = 0;
            for (int i = 0; i < n; i++) {
                long curr = heap.poll();
                ugly = (int) curr;
                for (int fac : factors) {
                    long next = curr * fac;
                    if (seen.add(next)) {
                        heap.offer(next);
                    }
                }
            }
            return ugly;
        }
    }
//
//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/ugly-number-ii/solution/chou-shu-ii-by-leetcode-solution-uoqd/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution_dp {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            int p2 = 1, p3 = 1, p5 = 1;
            for (int i = 2; i <= n; i++) {
                int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
                dp[i] = Math.min(Math.min(num2, num3), num5);
                if (dp[i] == num2) {
                    p2++;
                }
                if (dp[i] == num3) {
                    p3++;
                }
                if (dp[i] == num5) {
                    p5++;
                }
            }
            return dp[n];

        }
    }

    public static void main(String[] args) {

    }


}
