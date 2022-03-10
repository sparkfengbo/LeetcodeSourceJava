import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L000036 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
    }

    public boolean isValidSudoku(char[][] board) {
        int LENGTH = 9;
        List<Set<Character>> lineCache = new ArrayList<>(9);
        List<Set<Character>> columnCache = new ArrayList<>(9);
        List<Set<Character>> squareCache = new ArrayList<>(9);

        for (int i = 0; i < LENGTH; i++) {
            lineCache.add(new HashSet<>());
            columnCache.add(new HashSet<>());
            squareCache.add(new HashSet<>());
        }

        for (int i = 0; i < LENGTH; i++) {
            Set<Character> line = lineCache.get(i);
            for (int j = 0; j < LENGTH; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                if (!line.add(c)) {
                    return false;
                }

                Set<Character> column = columnCache.get(j);
                if (!column.add(c)) {
                    return false;
                }

                int squareIndex = i / 3 * 3 + j / 3;
                Set<Character> square = squareCache.get(squareIndex);
                if (!square.add(c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
