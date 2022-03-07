import datastruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode647 {

    public static void main(String[] args) {

    }


    /**
     * 采用了Leetcode5的解法，使用动态规划
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int n = s.length();
        if (n == 1) {
            return 1;
        }

        boolean[][] dp = new boolean[n][n];
        int ans = 0;
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
                if (dp[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 中心扩展
     * @param s
     * @return
     */
    public int countSubstrings_2(String s) {
        int ans = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                int l = i;
                int r = i + j;
                while (l >= 0 && r < n && s.charAt(l--) == s.charAt(r++)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
