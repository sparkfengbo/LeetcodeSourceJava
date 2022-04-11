import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode91_解码方法 {

    class Solution {
        public int numDecodings(String s) {
            int n = s.length();
            int[] f = new int[n + 1];
            f[0] = 1;
            for (int i = 1; i <= n; ++i) {
                if (s.charAt(i - 1) != '0') {
                    f[i] += f[i - 1];
                }
                if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                    f[i] += f[i - 2];
                }
            }
            return f[n];
        }
    }


    /**
     * 状态方程
     * <p>
     * dp[i]  s[0:i] 最大的个数
     * <p>
     * dp[i] = dp[i-1] (if s[i] != '0') + dp[i-2] if (s[i-1:i] in table)
     * <p>
     * 边界：
     * dp[0] = s[0] != '0' ? 1
     * dp[1] = s[0:1] in table ? 2:1
     *
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int tmp = 10 * (s.charAt(0) - '0') + s.charAt(1) - '0';
        if(s.charAt(1) != '0' ) {
            dp[1]++;
        }
        if (tmp >= 10 && tmp <= 26) {
            dp[1]++;
        }
        for (int i = 2; i < n; i++) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }

            tmp = 10 * (s.charAt(i - 1) - '0') + s.charAt(i) - '0';
            if (tmp >= 10 && tmp <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("0"));

        System.out.println(numDecodings("10"));

        //2
        System.out.println(numDecodings("12"));

        //3
        /**
         *         22 6
         *         2 26
         *
         *         2 2 6
         */
        System.out.println(numDecodings("226"));
    }
}
