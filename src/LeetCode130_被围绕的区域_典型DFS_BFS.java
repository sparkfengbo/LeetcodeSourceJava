import com.sun.org.apache.xpath.internal.operations.Bool;
import org.omg.CORBA.INTERNAL;

import java.util.*;

public class LeetCode130_被围绕的区域_典型DFS_BFS {

    public static class Solution1 {
        int n, m;

        public void solve(char[][] board) {
            n = board.length;
            if (n == 0) {
                return;
            }

            m = board[0].length;

            for (int i = 0; i < n; i++) {
                dfs(board, i, 0);
                dfs(board, i, m - 1);
            }

            for (int i = 1; i < m - 1; i++) {
                dfs(board, 0, i);
                dfs(board, n - 1, i);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'A') {
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        public void dfs(char[][] board, int x, int y) {
            if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
                return;
            }
            board[x][y] = 'A';
            dfs(board, x + 1, y);
            dfs(board, x - 1, y);
            dfs(board, x, y + 1);
            dfs(board, x, y - 1);
        }
    }

    public static class Solution2 {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        public void solve(char[][] board) {
            int n = board.length;
            if (n == 0) {
                return;
            }
            int m = board[0].length;
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (board[i][0] == 'O') {
                    queue.offer(new int[]{i, 0});
                    board[i][0] = 'A';
                }

                if (board[i][m - 1] == 'O') {
                    queue.offer(new int[]{i, m - 1});
                    board[i][m - 1] = 'A';
                }
            }

            for (int i = 1; i < m - 1; i++) {
                if (board[0][i] == 'O') {
                    queue.offer(new int[]{0, i});
                    board[0][i] = 'A';
                }

                if (board[n - 1][i] == 'O') {
                    queue.offer(new int[]{n - 1, i});
                    board[n - 1][i] = 'A';
                }
            }

            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int i = 0; i < 4; i++) {
                    int mx = x + dx[i], my = y + dy[i];
                    if (mx < 0 || my < 0 || mx >= n || my >= m || board[mx][my] != 'O') {
                        continue;
                    }
                    queue.offer(new int[]{mx, my});
                    board[mx][my] = 'A';
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'A') {
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] b = new char[][]{
//                {'O', 'O'},
//                {'O', 'O'},
//                {'O', 'X', 'X', 'O', 'X'},
//                {'X', 'O', 'O', 'X', 'O'},
//                {'X', 'O', 'X', 'O', 'X'},
//                {'O', 'X', 'O', 'O', 'O'},
//                {'X', 'X', 'O', 'X', 'O'}


//                {'O', 'O', 'O'},
//                {'O', 'O', 'O'},
//                {'O', 'O', 'O'}
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}
//        ["O","X","X","O","X"],
//        ["X","X","X","X","O"],
//        ["X","X","X","O","X"],
//        ["O","X","O","O","O"],
//        ["X","X","O","X","O"]
//                                {'O', 'X', 'X', 'O', 'X'},
//                {'X', 'O', 'O', 'X', 'O'},
//                {'X', 'O', 'X', 'O', 'X'},
//                {'O', 'X', 'O', 'O', 'O'},
//                {'X', 'X', 'O', 'X', 'O'}
        };
        solve(b);

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Set<Integer/*i * n + j*/> nonBoardSet = new HashSet<>();
        Set<Integer/*i * n + j*/> boarderSet = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    int index = i * n + j;
                    if (i == 0 || i == m - 1 || j == n - 1 || j == 0) {
                        boarderSet.add(index);
                    } else {
                        nonBoardSet.add(index);
                    }
                }
            }
        }

        int[] direction = new int[]{-1, -n, 1, n};

        for (Integer entry : boarderSet) {
            if (visited.contains(entry)) {
                continue;
            }

            Queue<Integer> que = new LinkedList<>();
            que.offer(entry);

            while (!que.isEmpty()) {
                int index = que.poll();
                if (visited.contains(index)) {
                    continue;
                }

                for (int i = 0; i < direction.length; i++) {
                    int newIndex = index + direction[i];
                    int r = newIndex / n;
                    int c = newIndex % n;

                    if (r >= 0 && r < m && c >= 0 && c < n && board[r][c] == 'O') {
                        if (!visited.contains(newIndex)) {
                            que.offer(newIndex);
                        }
                        nonBoardSet.remove(newIndex);
                    }
                }
                visited.add(index);
            }
        }

        for (Integer index : nonBoardSet) {
            board[index / n][index % n] = 'X';
        }

    }
}
