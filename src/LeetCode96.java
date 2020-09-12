public class LeetCode96 {
    /**
     * 有序序列 1 ~ n
     * G[n] 长度为 n 的序列能构成的不同二叉搜索树的个数。
     * F[i,n]为 以 i 为根、序列长度为 n 的不同二叉搜索树个数 (1≤i≤n)。
     *
     * G[0] = 0 G[1] = 1
     *
     * G[i] = sum F[i,n]  1 <= i <=n
     * F[i，n] = G[i-1] * G[n-1]
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }


    public static void main(String[] args) {


    }
}
