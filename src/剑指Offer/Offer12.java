package 剑指Offer;

public class Offer12 {

    class Solution {
        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(dfs(board, words, i, j, 0)) return true;
                }
            }
            return false;
        }
        boolean dfs(char[][] board, char[] word, int i, int j, int k) {
            if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
            if(k == word.length - 1) return true;
            board[i][j] = '\0';
            boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                    dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
            board[i][j] = word[k];
            return res;
        }
    }


    class Solution_ {
        final int[][] dirs = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        int m, n;
        boolean[][] visited;

        public boolean exist(char[][] board, String word) {
            m = board.length;
            n = board[0].length;
            visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    visited[i][j] = true;
                    if (backtrace(board, word, 0, i, j)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
            return false;
        }

        private boolean backtrace(char[][] board, String word, int index, int r, int c) {
            if (index == word.length()) {
                return true;
            }

            if (index == word.length() - 1 && word.charAt(index) == board[r][c]) {
                return true;
            }

            if (word.charAt(index) != board[r][c]) {
                return false;
            }

            for (int i = 0; i < dirs.length; i++) {
                int[] dir = dirs[i];
                int row = r + dir[0];
                int column = c + dir[1];

                if (row >= 0 && row < m && column >= 0 && column < n && !visited[row][column]) {
                    visited[row][column] = true;
                    if (backtrace(board, word, index + 1, row, column)) {
                        return true;
                    }
                    visited[row][column] = false;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {

    }
}
