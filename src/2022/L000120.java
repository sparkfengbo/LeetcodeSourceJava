import datastruct.ListNode;

import java.util.List;

public class L000120 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
    }


    /**
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        int ans = dp[0][0];
        for (int i = 1; i < n; i++) {
            List<Integer> cur = triangle.get(i);
            int levelMin = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                int topLeft = j >= 1 ? dp[i - 1][j - 1] + cur.get(j) : Integer.MAX_VALUE;
                int top = j <= i - 1 ? dp[i - 1][j] + cur.get(j) : Integer.MAX_VALUE;
                dp[i][j] = Math.min(topLeft, top);
                levelMin = Math.min(dp[i][j], levelMin);
            }
            ans = levelMin;
        }

        return ans;
    }
}
