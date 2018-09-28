import java.util.Arrays;

/**
 * 螺旋矩阵 II
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class LeetCode59 {

    public static void main(String[] args) {
        int[][] result = generateMatrix(4);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public static int[][] generateMatrix(int n) {

        int total = n * n;
        int current = 1;

        int[][] result = new int[n][n];

        int startRow = 0, endRow = n - 1, startCol = 0, endCol = n - 1;


        while (current <= total) {

            //从左到右
            for (int i = startCol; i <= endCol; i++) {
                result[startRow][i] = current++;
            }
            startRow++;

            //从上到下
            for (int i = startRow; i <= endRow; i++) {
                result[i][endCol] = current++;
            }
            endCol--;

            //从右到左
            for (int i = endCol; i >= startCol; i--) {
                result[endRow][i] = current++;
            }
            endRow--;

            //从下到上
            for (int i = endRow; i >= startRow; i--) {
                result[i][startCol] = current++;
            }
            startCol++;
        }
        return result;
    }

}
