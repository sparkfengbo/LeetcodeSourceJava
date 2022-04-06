public class LeetCode149 {

    class Solution {
        public int maxPoints(int[][] points) {
            int n = points.length;
            int res = 0;
            if (n == 1) {
                return 1;
            }

            for (int i = 0; i < n; i++) {
                int x1 = points[i][0], y1 = points[i][1];
                for (int j = i + 1; j < n; j++) {
                    int tmp = 0;
                    int x2 = points[j][0], y2 = points[j][1];
                    int dy = y1- y2;
                    int dx = x1- x2;
                    for (int[] p : points) {
                        if (dy * (p[0] - x1) == dx * (p[1] - y1)) {
                            tmp++;
                        }
                    }
                    res = Math.max(res, tmp);
                }
            }

            return res;

        }
    }

    public static void main(String[] args) {

    }
}
