import java.util.*;

public class LeetCode36_有效的数独 {

    public static void main(String[] args) {
        System.out.print("");
    }

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            boolean[] used = new boolean[9];

            for (int i = 0; i < 9; i++) {
                Arrays.fill(used, false);

                for (int j = 0; j < 9; j++) {
                    if (!check(board[i][j], used)) {
                        return false;
                    }
                }

                Arrays.fill(used, false);
                for (int j = 0; j < 9; j++) {
                    if (!check(board[j][i], used)) {
                        return false;
                    }
                }
            }

            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    Arrays.fill(used, false);
                    for (int i = r * 3; i < r * 3 + 3; i++) {
                        for (int j = c * 3; j < c * 3 + 3; j++) {
                            if (!check(board[i][j], used)) {
                                return false;
                            }
                        }
                    }
                }
            }

            return true;
        }

        public boolean check(char ch, boolean[] used) {
            if (ch == '.') {
                return true;
            }

            if (used[ch - '1']) return false;

            return used[ch - '1'] = true;
        }
    }

    public boolean isValidSudoku_me(char[][] board) {
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
