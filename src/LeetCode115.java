public class LeetCode115 {

    /**
     * n >= m   else false
     * dp[i][j] 代表 s[0:i] 到 t[0:j]的最大匹配数
     * <p>
     * dp[n][m] is target
     * <p>
     * 状态方程：
     * dp[i][j] =  dp[i-1][j-1] + dp[i-1][j]   s[i]  == t[j]
     *             dp[i-1][j]                  s[i]  != t[j]
     * dp[0][0] 代表空字符串
     * @param s
     * @param t
     * @return
     */
    public static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n < m) {
            return 0;
        }

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1) != t.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("babgbag", "bag"));

    }
}
