
public class LeetCode10_正则表达式匹配 {
    public static void main(String[] args) {


    }

    class Solution {

        /**
         * f[i][j] 表示  s 的前  i 个字符与  p 中的前 j  个字符是否能够匹配
         *
         * 以一个例子详解动态规划转移方程：
         * S = abbbbc
         * P = ab*d*c
         * 1. 当 i, j 指向的字符均为字母（或 '.' 可以看成一个特殊的字母）时，
         *    只需判断对应位置的字符即可，
         *    若相等，只需判断 i,j 之前的字符串是否匹配即可，转化为子问题 f[i-1][j-1].
         *    若不等，则当前的 i,j 肯定不能匹配，为 false.
         *
         *        f[i-1][j-1]   i
         *             |        |
         *    S [a  b  b  b  b][c]
         *
         *    P [a  b  *  d  *][c]
         *                      |
         *                      j
         *
         *
         * 2. 如果当前 j 指向的字符为 '*'，则不妨把类似 'a*', 'b*' 等的当成整体看待。
         *    看下面的例子
         *
         *             i
         *             |
         *    S  a  b [b] b  b  c
         *
         *    P  a [b  *] d  *  c
         *             |
         *             j
         *
         *    注意到当 'b*' 匹配完 'b' 之后，它仍然可以继续发挥作用。
         *    因此可以只把 i 前移一位，而不丢弃 'b*', 转化为子问题 f[i-1][j]:
         *
         *          i
         *          | <--
         *    S  a [b] b  b  b  c
         *
         *    P  a [b  *] d  *  c
         *             |
         *             j
         *
         *    另外，也可以选择让 'b*' 不再进行匹配，把 'b*' 丢弃。
         *    转化为子问题 f[i][j-2]:
         *
         *             i
         *             |
         *    S  a  b [b] b  b  c
         *
         *    P [a] b  *  d  *  c
         *       |
         *       j <--
         *
         * 3. 冗余的状态转移不会影响答案，
         *    因为当 j 指向 'b*' 中的 'b' 时, 这个状态对于答案是没有用的,
         *    原因参见评论区 稳中求胜 的解释, 当 j 指向 '*' 时,
         *    dp[i][j]只与dp[i][j-2]有关, 跳过了 dp[i][j-1].
         * @param s
         * @param p
         * @return
         */
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();

            boolean[][] f = new boolean[m + 1][n + 1];
            f[0][0] = true;

            for (int i = 0; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (p.charAt(j - 1) == '*') {
                        f[i][j] = f[i][j - 2];
                        if (matches(s, p, i, j - 1)) {
                            f[i][j] = f[i][j] || f[i - 1][j];
                        }
                    } else {
                        if (matches(s, p, i, j)) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    }
                }
            }
            return f[m][n];
        }

        public boolean matches(String s, String p, int i, int j) {
            if (i == 0) {
                return false;
            }
            if (p.charAt(j - 1) == '.') {
                return true;
            }
            return s.charAt(i - 1) == p.charAt(j - 1);
        }
    }
}
