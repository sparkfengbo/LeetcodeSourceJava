public class LeetCode980_不同路径III {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsIII(new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1},
        }));
    }


    static class Solution {
        public int uniquePathsIII(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int zeroCount = 0;
            int[] start = {-1, -1};
            int[] end = {-1, -1};
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        start[0] = i;
                        start[1] = j;
                    } else if (grid[i][j] == 2) {
                        end[0] = i;
                        end[1] = j;
                    } else if (grid[i][j] == 0) {
                        zeroCount++;
                    }
                }
            }
            boolean[][] visited = new boolean[m][n];
            return dfs(start[0], start[1], end[0], end[1], visited, grid, zeroCount, -1);
        }

        public int dfs(int r, int c, int endR, int endC, boolean[][] visited, int[][] grid, int zeroCount, int curZero) {
            if (r == endR && c == endC) {
                if (curZero == zeroCount) {
                    return 1;
                } else {
                    return 0;
                }
            }

            int m = grid.length;
            int n = grid[0].length;

            if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c] || grid[r][c] == -1) {
                return 0;
            }

            int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            visited[r][c] = true;
            curZero++;
            int count = 0;
            for (int i = 0; i < dir.length; i++) {
                count += dfs(r + dir[i][0], c + dir[i][1], endR, endC, visited, grid, zeroCount, curZero);
            }
            curZero--;
            visited[r][c] = false;
            return count;
        }
    }

    /**
     * https://leetcode-cn.com/problems/unique-paths-iii/solution/bu-tong-lu-jing-iii-by-leetcode/
     */
    static class Solution_leetcode_1 {
        int ans;
        int[][] grid;
        int tr, tc;
        int[] dr = new int[]{0, -1, 0, 1};
        int[] dc = new int[]{1, 0, -1, 0};
        int R, C;

        public int uniquePathsIII(int[][] grid) {
            this.grid = grid;
            R = grid.length;
            C = grid[0].length;

            int todo = 0;
            int sr = 0, sc = 0;
            for (int r = 0; r < R; ++r)
                for (int c = 0; c < C; ++c) {
                    if (grid[r][c] != -1) {
                        todo++;
                    }

                    if (grid[r][c] == 1) {
                        sr = r;
                        sc = c;
                    } else if (grid[r][c] == 2) {
                        tr = r;
                        tc = c;
                    }
                }

            ans = 0;
            dfs(sr, sc, todo);
            return ans;
        }

        public void dfs(int r, int c, int todo) {
            todo--;
            if (todo < 0) return;
            if (r == tr && c == tc) {
                if (todo == 0) ans++;
                return;
            }

            grid[r][c] = 3;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                    if (grid[nr][nc] % 2 == 0)
                        dfs(nr, nc, todo);
                }
            }
            grid[r][c] = 0;
        }
    }

    class Solution_leetcode_2 {
        int ans;
        int[][] grid;
        int R, C;
        int tr, tc, target;
        int[] dr = new int[]{0, -1, 0, 1};
        int[] dc = new int[]{1, 0, -1, 0};
        Integer[][][] memo;

        public int uniquePathsIII(int[][] grid) {
            this.grid = grid;
            R = grid.length;
            C = grid[0].length;
            target = 0;

            int sr = 0, sc = 0;
            for (int r = 0; r < R; ++r)
                for (int c = 0; c < C; ++c) {
                    if (grid[r][c] % 2 == 0)
                        target |= code(r, c);

                    if (grid[r][c] == 1) {
                        sr = r;
                        sc = c;
                    } else if (grid[r][c] == 2) {
                        tr = r;
                        tc = c;
                    }
                }

            memo = new Integer[R][C][1 << R*C];
            return dp(sr, sc, target);
        }

        public int code(int r, int c) {
            return 1 << (r * C + c);
        }

        public Integer dp(int r, int c, int todo) {
            if (memo[r][c][todo] != null)
                return memo[r][c][todo];

            if (r == tr && c == tc) {
                return todo == 0 ? 1 : 0;
            }

            int ans = 0;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                    if ((todo & code(nr, nc)) != 0)
                        ans += dp(nr, nc, todo ^ code(nr, nc));
                }
            }
            memo[r][c][todo] = ans;
            return ans;
        }
    }
}
