
public class LeetCode44_通配符匹配 {
    public static void main(String[] args) {


    }


    /**
     * dp[i, j]
     *              p[j - 1] == ?          dp[i-1][j-1]
     *              p[j - 1] == *          dp[i-1][j] || dp[i][j-1]  //没匹配上 dp[i][j-1]  匹配上，还是dp[i-1][j]，因为*能匹配任意字符串，需要携带到新得dp中
     *              s[i - 1] == p[j - 1]   dp[i-1][j-1]
     *
     *
     * dp[0][0]  true
     * dp[i][0]   false
     * dp[0][j]  *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }


        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
