import java.util.HashSet;
import java.util.Set;

public class LeetCode_剑指offer_04 {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int r = 0, c = column - 1;
        while (r < row && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
