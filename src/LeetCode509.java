public class LeetCode509 {

//    public int fib(int N) {
//        if (N <= 1) {
//            return N;
//        }
//        return fib(N-1) + fib(N-2);
//    }

    /**
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     *
     * F(2) = 0 + 1 = 1;
     * F(3) = 1 + 1 = 2;
     * F(4) = 2 + 1 = 3
     * @param N
     * @return
     */
    public static int fib(int N) {
        if (N == 0) {
            return 0;
        }
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <=N; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[N];
//        int prev_n_2 = 0;
//        int prev_n_1 = 1;
//
//
//        int ans = 0;
//        for (int i = 2; i < N; i++) {
//            ans += prev_n_1 + prev_n_2;
//            prev_n_2 = prev_n_1;
//            prev_n_1 = ans;
//        }
//        return ans;
    }


    public static void main(String[] args) {
        //1
        System.out.println(fib(2));
        //2
        System.out.println(fib(3));
        //3
        System.out.println(fib(4));

    }
}
