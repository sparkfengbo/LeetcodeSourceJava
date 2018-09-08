import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class LeetCode118 {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows <= 0) {
            return result;
        }

        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        result.add(row1);

        if (numRows == 1) {
            return result;
        }

        List<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);
        result.add(row2);

        if (numRows == 2) {
            return result;
        }

        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            //index 0
            row.add(1);

            List<Integer> prevRow = result.get(i - 1);
            if (prevRow == null) {
                throw new NullPointerException();
            }

            for (int j = 0; j < prevRow.size() - 1; j++) {
                row.add(prevRow.get(j) + prevRow.get(j + 1));
            }

            //index length-1
            row.add(1);
            result.add(row);
        }
        return result;
    }
}
