import utils.Utils;

public class LeetCode132 {

    /**
     * dp[i] = s[0:i]的最短
     * <p>
     * dp[i] =  s[0:i] 是回文   -  0
     *          s[0:i] 不是回文  - dp[j] + 1  0 < j < i    s[j+1:i]是回文
     *
     * @param s
     * @return
     */
    public static int minCut(String s) {
        int n = s.length();
        if (n <= 1) {
            return 0;
        }


        //判断是否是回文
        boolean[][] P = new boolean[n][n];
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                if (l == 0) {
                    P[i][j] = true;
                } else if (l == 1) {
                    P[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    P[i][j] = s.charAt(i) == s.charAt(j) && P[i + 1][j - 1];
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


    public static void main(String[] args) {
        Utils.println(minCut("aab"));
        Utils.println(minCut("cdd"));
        Utils.println(minCut("ababbbabbaba"));
        Utils.println(minCut("ababbbabbaba"));//3
    }

    /**
     *     作者：liweiwei1419
     *     链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii/solution/dong-tai-gui-hua-by-liweiwei1419-2/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public int minCut2(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return 0;
        }

        // 状态定义：dp[i]：前缀子串 s[0:i] （包括索引 i 处的字符）符合要求的最少分割次数
        // 状态转移方程：
        // dp[i] = min(dp[j] + 1 if s[j + 1: i] 是回文 for j in range(i))

        int[] dp = new int[len];
        // 2 个字符最多分割 1 次；
        // 3 个字符最多分割 2 次
        // 初始化的时候，设置成为这个最多分割次数

        for (int i = 0; i < len; i++) {
            dp[i] = i;
        }

        // 参考「力扣」第 5 题：最长回文子串 动态规划 的解法
        boolean[][] checkPalindrome = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || checkPalindrome[left + 1][right - 1])) {
                    checkPalindrome[left][right] = true;
                }
            }
        }

        // 1 个字符的时候，不用判断，因此 i 从 1 开始
        for (int i = 1; i < len; i++) {
            if (checkPalindrome[0][i]){
                dp[i] = 0;
                continue;
            }

            // 注意：这里是严格，要保证 s[j + 1:i] 至少得有一个字符串
            for (int j = 0; j < i; j++) {
                if (checkPalindrome[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }
}
