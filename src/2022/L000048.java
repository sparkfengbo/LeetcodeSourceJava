import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L000048 extends Template {

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

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n / 2; i++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = tmp;
            }
        }
        for (int j = 0; j < n; j++) {

            for (int i = 0; i < j; i++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
