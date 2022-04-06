import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.spiralOrder(new int[][]{
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10, 11, 12}
//        });
    }

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> order = new ArrayList<Integer>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return order;
            }
            int rows = matrix.length, columns = matrix[0].length;
            boolean[][] visited = new boolean[rows][columns];
            int total = rows * columns;
            int row = 0, column = 0;
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int directionIndex = 0;
            for (int i = 0; i < total; i++) {
                order.add(matrix[row][column]);
                visited[row][column] = true;
                int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
                if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                    directionIndex = (directionIndex + 1) % 4;
                }
                row += directions[directionIndex][0];
                column += directions[directionIndex][1];
            }
            return order;
        }
    }
//
//
//    static class Solution {
//        public List<Integer> spiralOrder(int[][] matrix) {
//            List<Integer> ans = new ArrayList<>();
//            int m = matrix.length;
//            int n = matrix[0].length;
//            int up = 0;
//            int bottom = m - 1;
//            int left = 0;
//            int right = n - 1;
//            while (up <= bottom) {
//                //left to right
//                for (int i = left; i <= right; i++) {
//                    ans.add(matrix[up][i]);
//                }
//                //top to bottom
//                for (int i = up + 1; i <= bottom; i++) {
//                    ans.add(matrix[i][right]);
//                }
//                //right to left
//                for (int i = right - 1; i >= left && bottom > up; i--) {
//                    ans.add(matrix[bottom][i]);
//                }
//                for (int i = bottom - 1; i >= up + 1 && right > left; i--) {
//                    ans.add(matrix[i][left]);
//                }
//                bottom--;
//                up++;
//                left++;
//                right--;
//            }
//            return ans;
//
//        }
//    }
}
