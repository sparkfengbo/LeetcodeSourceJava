package 剑指Offer;

import datastruct.ListNode;

public class Offer13 {
    static class Solution {

        boolean[][] visited;
        int ans = 0;
        int m, n;

        public int movingCount(int m, int n, int k) {
            this.m = m;
            this.n = n;
            visited = new boolean[m][n];
            dfs(0, 0, k);
            return ans;
        }

        private void dfs(int i, int j, int k) {
            if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
                return;
            }
            visited[i][j] = true;

            if (bitSum(i) + bitSum(j) <= k) {
                ans++;
            } else {
                return;
            }
            dfs(i + 1, j, k);
            dfs(i - 1, j, k);
            dfs(i, j + 1, k);
            dfs(i, j - 1, k);
        }

        private int bitSum(int n) {
            if (n == 0) {
                return 0;
            }
            int t = 10;
            int sum = 0;
            try {
                while (n != 0) {
                    int d = n % 10;
                    sum += d;
                    n = (n - d) / 10;
                }
            } catch (Exception e) {
                System.out.println();
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(36, 11, 15));
//        solution.movingCount(11, 8 ,16);
//        solution.bitSum(10);
    }


}
