import java.util.Arrays;

public class LeetCode60_排列序列 {

    public static void main(String[] args) {
        System.out.print("");
    }

    /**
     * https://leetcode-cn.com/problems/permutation-sequence/solution/di-kge-pai-lie-by-leetcode-solution/
     * @param n
     * @param k
     * @return
     */
    public static String getPermutation(int n, int k) {

        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);

        for (int i = 1; i <= n; i++) {
            int order = k / factorial[n - i] + 1;

            for (int j = 1; j <= n; j++) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }

            k %= factorial[n - i];
        }
        return ans.toString();
    }
}
