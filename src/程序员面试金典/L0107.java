package 程序员面试金典;

public class L0107 {
    public static void main(String[] args) {

    }
    public void rotate(int[][] matrix) {

        if (matrix.length <= 1 || matrix[0].length <= 1) {
            return;
        }

        //flip vertical
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[n - j - 1][i] ;
                matrix[n - j - 1][i] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < row; col++) {
                int tmp = matrix[row][col] ;
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }
    }
}
