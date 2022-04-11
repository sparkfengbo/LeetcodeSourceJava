import java.util.HashMap;
import java.util.Map;

public class LeetCode87_扰乱字符串 {


    /**
     * 链接：https://leetcode-cn.com/problems/scramble-string/solution/miao-dong-de-qu-jian-xing-dpsi-lu-by-sha-yu-la-jia/
     * <p>
     * <p>
     * dp[i][j][len] 表示从字符串 S  中 i  开始长度为 len  的字符串是否能变换为从字符串 T  中 j  开始长度为 len  的字符串
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isScramble(String s1, String s2) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int n = s1.length();
        int m = s2.length();
        if (n != m) {
            return false;
        }
        boolean[][][] dp = new boolean[n][n][n + 1];
        // 初始化单个字符的情况
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = chs1[i] == chs2[j];
            }
        }

        // 枚举区间长度 2～n
        for (int len = 2; len <= n; len++) {
            // 枚举 S 中的起点位置
            for (int i = 0; i <= n - len; i++) {
                // 枚举 T 中的起点位置
                for (int j = 0; j <= n - len; j++) {
                    // 枚举划分位置
                    for (int k = 1; k <= len - 1; k++) {
                        // 第一种情况：S1 -> T1, S2 -> T2
                        if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        // 第二种情况：S1 -> T2, S2 -> T1
                        // S1 起点 i，T2 起点 j + 前面那段长度 len-k ，S2 起点 i + 前面长度k
                        if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }

    public static void main(String[] args) {
        System.out.println(isScramble("great", "rgeat"));

        System.out.println(isScramble("abcde", "caebd"));

    }

    //    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/scramble-string/solution/rao-luan-zi-fu-chuan-by-leetcode-solutio-8r9t/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution {
        // 记忆化搜索存储状态的数组
        // -1 表示 false，1 表示 true，0 表示未计算
        int[][][] memo;
        String s1, s2;

        public boolean isScramble(String s1, String s2) {
            int length = s1.length();
            this.memo = new int[length][length][length + 1];
            this.s1 = s1;
            this.s2 = s2;
            return dfs(0, 0, length);
        }

        // 第一个字符串从 i1 开始，第二个字符串从 i2 开始，子串的长度为 length，是否和谐
        public boolean dfs(int i1, int i2, int length) {
            if (memo[i1][i2][length] != 0) {
                return memo[i1][i2][length] == 1;
            }

            // 判断两个子串是否相等
            if (s1.substring(i1, i1 + length).equals(s2.substring(i2, i2 + length))) {
                memo[i1][i2][length] = 1;
                return true;
            }

            // 判断是否存在字符 c 在两个子串中出现的次数不同
            if (!checkIfSimilar(i1, i2, length)) {
                memo[i1][i2][length] = -1;
                return false;
            }

            // 枚举分割位置
            for (int i = 1; i < length; ++i) {
                // 不交换的情况
                if (dfs(i1, i2, i) && dfs(i1 + i, i2 + i, length - i)) {
                    memo[i1][i2][length] = 1;
                    return true;
                }
                // 交换的情况
                if (dfs(i1, i2 + length - i, i) && dfs(i1 + i, i2, length - i)) {
                    memo[i1][i2][length] = 1;
                    return true;
                }
            }

            memo[i1][i2][length] = -1;
            return false;
        }

        public boolean checkIfSimilar(int i1, int i2, int length) {
            Map<Character, Integer> freq = new HashMap<Character, Integer>();
            for (int i = i1; i < i1 + length; ++i) {
                char c = s1.charAt(i);
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            for (int i = i2; i < i2 + length; ++i) {
                char c = s2.charAt(i);
                freq.put(c, freq.getOrDefault(c, 0) - 1);
            }
            for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
                int value = entry.getValue();
                if (value != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
