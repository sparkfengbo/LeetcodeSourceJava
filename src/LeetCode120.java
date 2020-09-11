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

}
