package 程序员面试金典;

public class L0108 {
    public static void main(String[] args) {
        System.out.println();

    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] visRow = new int[m];
        int[] visCol = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    visCol[j] = 1;
                    visRow[i] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
           if (visRow[i] == 1) {
               for (int j = 0; j < n; j++) {
                   matrix[i][j] = 0;
               }
           }
        }

        for (int j = 0; j < n; j++) {
            if (visCol[j] == 1) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
