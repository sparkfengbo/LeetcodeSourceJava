package 剑指Offer;

public class Offer10_II {

    class Solution {
        public int numWays(int n) {
            if (n < 2) {
                return 1;
            }
            final int MOD = 1000000007;

            int tmp = 0, pre = 1, cur = 1;

            for (int i = 2; i <= n; i++) {
                tmp = cur;
                cur = (cur + pre) % MOD;
                pre = tmp;
            }
            return cur;
        }
    }
}
