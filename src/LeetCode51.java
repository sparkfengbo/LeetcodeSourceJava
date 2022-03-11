import utils.Utils;

import java.util.*;

public class LeetCode51 {

    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> solutions = new ArrayList<List<String>>();
            int[] queens = new int[n];
            Arrays.fill(queens, -1);
            Set<Integer> columns = new HashSet<Integer>();
            Set<Integer> diagonals1 = new HashSet<Integer>();
            Set<Integer> diagonals2 = new HashSet<Integer>();
            backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
            return solutions;
        }

        public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
            if (row == n) {
                List<String> board = generateBoard(queens, n);
                solutions.add(board);
            } else {
                for (int i = 0; i < n; i++) {
                    if (columns.contains(i)) {
                        continue;
                    }
                    int diagonal1 = row - i;
                    if (diagonals1.contains(diagonal1)) {
                        continue;
                    }
                    int diagonal2 = row + i;
                    if (diagonals2.contains(diagonal2)) {
                        continue;
                    }
                    queens[row] = i;
                    columns.add(i);
                    diagonals1.add(diagonal1);
                    diagonals2.add(diagonal2);
                    backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                    queens[row] = -1;
                    columns.remove(i);
                    diagonals1.remove(diagonal1);
                    diagonals2.remove(diagonal2);
                }
            }
        }

        public List<String> generateBoard(int[] queens, int n) {
            List<String> board = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[queens[i]] = 'Q';
                board.add(new String(row));
            }
            return board;
        }
    }

    public static void main(String[] args) {
//        System.out.println(myPow(4, 2));
//        System.out.println(myPow(2, -2));
//        System.out.println(myPow(2, -2147483648));


        Utils.printNestList(solveNQueens(4));
        System.out.println();
        Utils.printNestList(solveNQueens(1));
        System.out.println();
        Utils.printNestList(solveNQueens(2));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<Integer> pline = new ArrayList<>();
        List<Integer> nline = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] column = new boolean[n];
        dfs(0, column, pline, nline, n, path, res);
        return res;
    }

    public static void dfs(int row, boolean[] column, List<Integer> pline, List<Integer> nline, int n, List<Integer> path, List<List<String>> res) {
        if (row == n) {
            List<String> p = new ArrayList<>();
            for (int i = 0; i < path.size(); i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == path.get(i)) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                p.add(sb.toString());
            }
            res.add(p);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (column[i] || pline.contains(row + i) || nline.contains(row - i)) {
                continue;
            }
            column[i] = true;
            pline.add(row + i);
            nline.add(row - i);
            path.add(i);
            dfs(row + 1, column, pline, nline, n, path, res);
            column[i] = false;
            path.remove(path.size() - 1);
            pline.remove(pline.size() - 1);
            nline.remove(nline.size() - 1);
        }
    }
}
