import java.util.HashMap;
import java.util.HashSet;

public class LeetCode36 {

    public static void main(String[] args) {
        System.out.print("");
    }

    public boolean isValidSudoku(char[][] board) {

        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer>[] columns = new HashSet[9];
        HashSet<Integer>[] dashes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            dashes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int num = board[r][c] - '0';
                    if (rows[r].contains(num) || columns[c].contains(num)) {
                        return false;
                    }

                    int dashIndex = (r / 3) * 3 + c / 3;
                    if (dashes[dashIndex].contains(num)) {
                        return false;
                    }
                    rows[r].add(num);
                    columns[c].add(num);
                    dashes[dashIndex].add(num);
                }
            }
        }
        return true;
    }
}
