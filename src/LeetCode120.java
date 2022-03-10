import java.util.ArrayList;
import java.util.List;

public class LeetCode120 {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> r1 = new ArrayList<>();
        r1.add(2);
        triangle.add(r1);

        List<Integer> r2 = new ArrayList<>();
        r2.add(3);
        r2.add(4);
        triangle.add(r2);

        List<Integer> r3 = new ArrayList<>();
        r3.add(6);
        r3.add(5);
        r3.add(7);
        triangle.add(r3);

        List<Integer> r4 = new ArrayList<>();
        r4.add(4);
        r4.add(1);
        r4.add(8);
        r4.add(3);
        triangle.add(r4);

        System.out.println(minimumTotal(triangle));
    }

    /**
     *
     * d[i][j] = Math.min(d[i-1][j] + num[i][j], d[i-1][j-1] + num[i][j])
     * d[i][0] = d[i-1][0] + num[i][0];
     *
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int h = triangle.size();
        if (h == 0) {
            return 0;
        }
        if (h == 1) {
            return triangle.get(0).get(0);
        }

        int[][] dp = new int[h][h];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < h; i++) {
            List<Integer> list = triangle.get(i);
            List<Integer> pre = triangle.get(i - 1);

            for (int j = 0; j < list.size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][0] + triangle.get(i).get(j);
                } else if (j == list.size() - 1) {
                    dp[i][j] = dp[i-1][pre.size() - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
                }
            }
        }

        int ans = dp[h-1][0];
        for (int i = 1; i < h; i++) {
            ans = Math.min(ans, dp[h-1][i]);
        }
        return ans;
    }


    /**
     *
     作者：LeetCode-Solution
     链接：https://leetcode-cn.com/problems/triangle/solution/san-jiao-xing-zui-xiao-lu-jing-he-by-leetcode-solu/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param triangle
     * @return
     */
    public int minimumTotal_pro(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[2][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            int curr = i % 2;
            int prev = 1 - curr;
            f[curr][0] = f[prev][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[curr][j] = Math.min(f[prev][j - 1], f[prev][j]) + triangle.get(i).get(j);
            }
            f[curr][i] = f[prev][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[(n - 1) % 2][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[(n - 1) % 2][i]);
        }
        return minTotal;

    }


    public int minimumTotal_2022(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        int ans = dp[0][0];
        for (int i = 1; i < n; i++) {
            List<Integer> cur = triangle.get(i);
            int levelMin = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                int topLeft = j >= 1 ? dp[i - 1][j - 1] + cur.get(j) : Integer.MAX_VALUE;
                int top = j <= i - 1 ? dp[i - 1][j] + cur.get(j) : Integer.MAX_VALUE;
                dp[i][j] = Math.min(topLeft, top);
                levelMin = Math.min(dp[i][j], levelMin);
            }
            ans = levelMin;
        }

        return ans;
    }

}
