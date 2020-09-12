public class LeetCode639 {

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
        int M = 1000000007;
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                dp[i + 1] = 9 * dp[i];
                if (s.charAt(i - 1) == '1')
                    dp[i + 1] = (dp[i + 1] + 9 * dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '2')
                    dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '*')
                    dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % M;
            } else {
                dp[i + 1] = s.charAt(i) != '0' ? dp[i] : 0;
                if (s.charAt(i - 1) == '1')
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '*')
                    dp[i + 1] = (dp[i + 1] + (s.charAt(i) <= '6' ? 2 : 1) * dp[i - 1]) % M;
            }
        }
        return (int) dp[s.length()];
    }

    public static void main(String[] args) {
//        System.out.println(numDecodings("0"));

        //9
//        System.out.println(numDecodings("*"));

        //18
        System.out.println(numDecodings("1*"));


        //1
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
