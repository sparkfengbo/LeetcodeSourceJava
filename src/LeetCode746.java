public class LeetCode746 {

    /**
     * https://leetcode-cn.com/problems/min-cost-climbing-stairs/solution/yi-bu-yi-bu-tui-dao-dong-tai-gui-hua-de-duo-chong-/
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        if (n <= 1) {
            return 0;
        }

        int[] dp = new int[n];

        dp[0] = 0;
        dp[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i], dp[i-2] + cost[i-1]) ;
        }
        return dp[n-1];
    }


    public static void main(String[] args) {

        //15
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));

        //6
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));

    }
}
