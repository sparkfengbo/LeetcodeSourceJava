import java.util.*;

public class LeetCode37 {

    public static void main(String[] args) {
        System.out.print("");
    }


    class Solution {
        private boolean[][] line = new boolean[9][9];
        private boolean[][] column= new boolean[9][9];
        private boolean[][][] block = new boolean[3][3][9];
        private boolean valid = false;
        private List<int[]> spaces = new ArrayList<>();

        public void solveSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        spaces.add(new int[]{i, j});
                    } else {
                        int digit = board[i][j] - '0' - 1;
                        line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                    }
                }
            }

            dfs(board, 0);
        }

        public void dfs(char[][] board, int pos) {
            if (pos == spaces.size()) {
                valid = true;
                return;
            }

            int[] space = spaces.get(pos);
            int i = space[0], j = space[1];
            for (int digit = 0; digit < 9 && !valid; ++digit) {
                if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                    board[i][j] = (char) (digit + '0' + 1);
                    dfs(board, pos + 1);
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
                }
            }
        }
    }

//    class Solution {
//        Map<Integer, Set<Integer>> row = new HashMap<>();
//        Map<Integer, Set<Integer>> column = new HashMap<>();
//        Map<Integer, Set<Integer>> grid = new HashMap<>();
//
//        int endR, endC;
//        int startR = -1, startC = -1;
//
//        public void solveSudoku(char[][] board) {
//            for (int i = 0; i < 9; i++) {
//                for (int j = 0; j < 9; j++) {
//                    if (!row.containsKey(i)) {
//                        row.put(i, new HashSet<>());
//                    }
//
//                    if (!column.containsKey(j)) {
//                        column.put(j, new HashSet<>());
//                    }
//
//                    int gridIndex = i / 3 * 3 + j / 3;
//                    if (!grid.containsKey(gridIndex)) {
//                        grid.put(gridIndex, new HashSet<>());
//                    }
//
//                    if (board[i][j] == '.') {
//                        if (startR == -1) {
//                            startR = i;
//                            startC = j;
//                        }
//                        endR = i;
//                        endC = j;
//                        continue;
//                    }
//                    Set<Integer> rowSet = row.get(i);
//                    rowSet.add(board[i][j] - '1');
//
//                    Set<Integer> cSet = column.get(j);
//                    cSet.add(board[i][j] - '1');
//
//                    Set<Integer> gSet = grid.get(gridIndex);
//                    gSet.add(board[i][j] - '1');
//                }
//            }
//            dfs(board, startR, startC, endR, endC);
//
//        }
//
//        private boolean dfs(char[][] board, int r, int c, int endR, int endC) {
//            if (board[r][c] >= '1' && board[r][c] <= '9') {
//                return;
//            }
//
//
//            if (r) {
//
//            }
//
//            int gridIndex = r / 3 * 3 + c / 3;
//            for (int i = 0; i < 9; i++) {
//                if (row.get(r).contains(i) || column.get(c).contains(i) || grid.get(gridIndex).contains(i)) {
//                    continue;
//                }
//                board[r][c] = (char) ('1' + i);
//                row.get(r).add(i);
//                column.get(c).add(i);
//                grid.get(gridIndex).add(i);
//                boolean find = false;
//                if (c == 8) {
//                    find = dfs(board, r + 1, c, endR, endC);
//                } else {
//                    find = dfs(board, r, c + 1, endR, endC);
//                }
//
//                if (!find) {
//                    board[r][c] = '.';
//                    row.get(r).remove(i);
//                    column.get(c).remove(i);
//                    grid.get(gridIndex).remove(i);
//                }
//            }
//        }
//    }

}
