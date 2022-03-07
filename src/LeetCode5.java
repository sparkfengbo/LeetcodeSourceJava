
public class LeetCode5 {

    /**
     * 动态规划
     * <p>
     * p[i, j] = p[i+1, j-1] && s[i] == s[j]
     * <p>
     * p[i, i] = true;
     * p[i, i + 1] = s[i] == s[i+1]
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        String ans = "";
        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
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


    /**
     * 中心扩散法
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        String ans = "";
        int n = s.length();

        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                if (len % 2 == 0) {
                    //偶数
                    start = i - (len / 2) + 1;
                    end = i + (len / 2);
                } else {
                    //奇数
                    start = i - ((len - 1) / 2);
                    end = i + ((len - 1) / 2);
                }
            }
        }
        ans = s.substring(start, end + 1);
        return ans;
    }

    private static int expand(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length()
                && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));

        System.out.println(longestPalindrome2("babad"));
        System.out.println(longestPalindrome2("cbbd"));
    }

}
