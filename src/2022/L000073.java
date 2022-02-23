import java.lang.reflect.Array;
import java.util.Arrays;

public class L000073 extends Template {

    public static void main(String[] args) {
//        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
    }

    public void setZeroes(int[][] matrix) {
        if( matrix == null || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] visRow = new boolean[m];
        Arrays.fill(visRow, false);
        boolean[] visCol = new boolean[n];
        Arrays.fill(visCol, false);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    visCol[j] = true;
                    visRow[i] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visRow[i] || visCol[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
