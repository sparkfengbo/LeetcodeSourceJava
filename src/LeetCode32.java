import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LeetCode32 {

    public static void main(String[] args) {
//        //2
//        int r = longestValidParentheses("(()");
//        System.out.println(r);
//        //4
//        int r2 = longestValidParentheses(")()())");
//        System.out.println(r2);

        //2
        int r3 = longestValidParentheses("()(()");
        System.out.println(r3);
    }

    /**
     * 动规求解
     *
     * dp[n]  长度为n的目标值
     *
     * dp[n]   s[n] == '('   dp[n] =  dp[n-1]
     *         s[n] == ')'   dp[n] =  dp[n-1] == (   dp[n-2] + 2
     *                                dp[n-1] != (   dp[n-2]
     *
     *
     * n >= 2
     *
     * dp[0] = 0
     * dp[1] = 0
     * dp[2] = s[0] == '(' s[1] == ')'
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {

        return -1;
    }
}
