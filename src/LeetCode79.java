import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class LeetCode79 {

    public static void main(String[] args) {

        Solution solution = new Solution();


        char[][] booad = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(solution.exist(booad, "ABCB"));
    }

    static class Solution {

        public boolean exist(char[][] board, String word) {
            boolean res = false;
            int m = board.length;
            int n = board[0].length;
            if (word.length() == 0 || m * n < word.length()) {
                return false;
            }

            int[] dirH = new int[]{-1, 1, 0, 0};
            int[] dirV = new int[]{0, 0, 1, -1};

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    Set<Pair<Integer, Integer>> visited = new HashSet<>();
                    if (backTrace(dirH, dirV, visited, i, j, m, n, 0, board, word)) {
                        return true;
                    }
                }
            }


            return res;
        }

        private boolean backTrace(int[] dirH, int[] dirV, Set<Pair<Integer, Integer>> visited, int r, int c, int m, int n, int level, char[][] board, String word) {
            if (level == word.length()) {
                return true;
            }

            if (r < 0 || c < 0 || r >= m || c >= n) {
                return false;
            }

            if (visited.contains(new Pair<>(r, c))) {
                return false;
            }

            visited.add(new Pair<>(r, c));
            if (board[r][c] == word.charAt(level)) {
                for (int i = 0; i < 4; i++) {
                    if (backTrace(dirH, dirV, visited, r + dirH[i], c + dirV[i], m, n, level + 1, board, word)) {
                        return true;
                    }
                }
            }
            visited.remove(new Pair<>(r, c));
            return false;
        }
    }
}
