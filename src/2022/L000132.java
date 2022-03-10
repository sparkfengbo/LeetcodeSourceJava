import sun.tools.jconsole.inspector.IconManager;

public class L000132 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
    }

    public int minCut(String s) {
        int n = s.length();
        if (n <= 1) {
            return 0;
        }


        boolean[][] P = new boolean[n][n];
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                if (l == 0) {
                    P[i][j] = true;
                } else if (l == 1) {
                    P[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    P[i][j] =  s.charAt(i) == s.charAt(j) && P[i + 1][j - 1];
                }
            }
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < n; i++) {
            if (P[0][i]) {
                dp[i] = 0;
                continue;
            }

            for (int j = 0; j < i; j++) {
                if (P[j+1][i]) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }

        return dp[n-1];
    }
}
