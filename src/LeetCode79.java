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

    class Solution_leetcode {
        public boolean exist(char[][] board, String word) {
            int h = board.length, w = board[0].length;
            boolean[][] visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    boolean flag = check(board, visited, i, j, word, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
            if (board[i][j] != s.charAt(k)) {
                return false;
            } else if (k == s.length() - 1) {
                return true;
            }
            visited[i][j] = true;
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            boolean result = false;
            for (int[] dir : directions) {
                int newi = i + dir[0], newj = j + dir[1];
                if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                    if (!visited[newi][newj]) {
                        boolean flag = check(board, visited, newi, newj, s, k + 1);
                        if (flag) {
                            result = true;
                            break;
                        }
                    }
                }
            }
            visited[i][j] = false;
            return result;
        }
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

            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (backTrace(dirH, dirV, visited, i, j, m, n, 0, board, word)) {
                        return true;
                    }
                }
            }
            return res;
        }

        private boolean backTrace(int[] dirH, int[] dirV, boolean[][] visited, int r, int c, int m, int n, int level, char[][] board, String word) {
            if (level == word.length()) {
                return true;
            }

            if (r < 0 || c < 0 || r >= m || c >= n) {
                return false;
            }

            if (visited[r][c]) {
                return false;
            }


            if (board[r][c] != word.charAt(level)) {
                return false;
            }

            visited[r][c] = true;
            for (int i = 0; i < 4; i++) {
                if (backTrace(dirH, dirV, visited, r + dirH[i], c + dirV[i], m, n, level + 1, board, word)) {
                    return true;
                }
            }
            visited[r][c] = false;
            return false;
        }
    }
}
