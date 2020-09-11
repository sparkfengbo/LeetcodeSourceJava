public class LeetCode48 {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return;
        }

        //transverse
        for(int r = 0; r < n; r++) {
            for (int c = r; c < n; c++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = tmp;
            }
        }

        //翻转行
        for(int r = 0; r < n; r++) {
            for (int c = 0; c < n / 2; c++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[r][n - 1 - c];
                matrix[r][n - 1 - c] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        rotate(test);

        for (int i = 0; i < test.length; i++) {
            System.out.print("[");
            for (int j = 0; j < test[i].length; j++) {
                System.out.print(test[i][j]);
                System.out.print(",");
            }
            System.out.println("]");
        }
    }
}
