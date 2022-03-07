public class L000005 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
    }



    public String longestPalindrome(String s) {
        int n = s .length();
        if (n == 1) {
            return s;
        }

        boolean[][] dp = new boolean[n][n];
        String ans = "";

        for (int l = 0; l < n; l++) {
            for (int i = 0; i < n - l; i++) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                if (ans.length() < l + 1 && dp[i][j]) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;

    }

}
