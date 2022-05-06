package 剑指Offer;

public class Offer14_I {
    class Solution {
        public int cuttingRope(int n) {
            final int MOD = 1000000007;
            int[] dp = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]) % MOD);
                }
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {

    }


}
