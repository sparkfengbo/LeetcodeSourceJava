import utils.Utils;

public class LeetCode_最大M字段和 {

    /**
     * dp[n][m]  为所求
     * dn[i][j] =   max (
     * dp[i-1][j] + num[i]   //第M个字段  包含了num[m]
     * <p>
     * Max(dp[k][j-1]   k [1, i -1])  + num[i]                //第M个字段  不包含num[m]，也就是num[m]独立成段
     * )
     *
     * @param num
     * @param m
     * @return
     */
    public static int maxMSubsetCount(int[] num, int m) {
        int n = num.length;
        /**
         * dp[i][j] [1, i]的第j个M字段和
         * dp[n][m] 为所求
         */
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 1; j <= m; j++) {
            int max = 0;
            for (int i = j; i <= n; i++) {
                //非常错误的一种写法： num[i - 1]可能会重复算
//                max = Math.max(max, dp[i - 1][j] + num[i - 1]);
//                max = Math.max(max, dp[i - 1][j - 1] + num[i - 1]);
//                dp[i][j] = max;

                max = Math.max(max, dp[i - 1][j - 1]);
                dp[i][j] = Math.max(max, dp[i - 1][j]+ num[i - 1]) ;
            }
        }


        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            ans = Math.max(ans, dp[i][m]);
        }

        return ans;
    }

    public static int maxMSubsetCount3(int[] num, int m) {
        int n = num.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 1; j <= m; ++j) {
            int MAX = 0;
            for (int i = j; i <= n - m + j; ++i) {
                // 之前使用i-1个数已经构成的j-1段的最大值
                // 之前使用i-1个数 已经构成j段的最大值
                // 上面两种情况构成的子段 均必须以第i-1个数结尾
                // 构成第i段  第i个数或者自成一段 或者 加入第i段
                // 两者取最大
                MAX = Math.max(MAX, dp[i - 1][j - 1]);
                dp[i][j] = Math.max(MAX, dp[i - 1][j]) + num[i - 1];
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; ++i)
            ans = Math.max(ans, dp[i][m]);
        return ans;
    }


    public static int sum(int[] a, int m) {
        int n = a.length;
        // n为数组中的个数
        int[][] b = new int[n + 1][m + 1];
        int[][] SUM = new int[n + 1][m + 1];
        for (int p = 0; p <= n; p++) {   // 一个子段获数字都不取时   //
            b[p][0] = 0;
            SUM[p][0] = 0;
        }//        for(int p=0;p<=m;p++)    {   // 当p > 0 时 并无意义, 此部分不会被用到,注释掉//        b[0][p] = 0;
        //        SUM[0][p] = 0;
        //    }
        for (int j = 1; j <= m; j++) {
            for (int i = j; i <= n - m + j; i++)
                // n=1 m=1  此时最大1子段为 a[0]  java 数组为从0开始的 需要注意 后面所有的第i个数为a[i-1];
                if (i == 1) {
                    b[i][j] = a[i - 1];
                    SUM[i][j] = a[i - 1];
                } else {
                    //先假设 第i个数作为最后一个子段的一部分
                    b[i][j] = b[i - 1][j] + a[i - 1];
                    // 若第i个数作为单独子段时 b[i][j]更大  则把a[i-1] 作为单独子段
                    // 考虑特殊情况  若第一个数字为负数    b[1][1]为负数  在求b[2][1] SUM[1][0]=0>b[1][1] 则舍去第一个数字  此处合理
                    if (SUM[i - 1][j - 1] + a[i - 1] > b[i][j]) b[i][j] = SUM[i - 1][j - 1] + a[i - 1];
                    //填写SUM[i][j]供以后使用
                    if (j < i) { // i 比j 大时
                        if (b[i][j] > SUM[i - 1][j]) {  //  用b[i][j] 与之前求的比较
                            SUM[i][j] = b[i][j];
                        } else {
                            SUM[i][j] = SUM[i - 1][j];
                        }
                    } else   // i = j
                    {
                        SUM[i][j] = SUM[i - 1][j - 1] + a[i - 1];
                    }
                }
        }
        return SUM[n][m];
    }

    public static void main(String[] args) {
        //33
        int[] a = new int[]{1, -2, 3, 4, -5, -6, 7, 18, -9};
        Utils.println(maxMSubsetCount(a, 3));
        Utils.println(maxMSubsetCount3(a, 3));
        Utils.println(sum(a, 3));

        //26
        int[] b = new int[]{-2, 11, -4, 13, -5, 6, -2};
        Utils.println(maxMSubsetCount(b, 2));
        Utils.println(maxMSubsetCount3(b, 2));
        Utils.println(sum(b, 2));

    }
}
