import utils.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode52_N皇后II {

    class Solution {
        public int totalNQueens(int n) {
            Set<Integer> columns = new HashSet<Integer>();
            Set<Integer> diagonals1 = new HashSet<Integer>();
            Set<Integer> diagonals2 = new HashSet<Integer>();
            return backtrack(n, 0, columns, diagonals1, diagonals2);
        }

        public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
            if (row == n) {
                return 1;
            } else {
                int count = 0;
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
                    columns.add(i);
                    diagonals1.add(diagonal1);
                    diagonals2.add(diagonal2);
                    count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
                    columns.remove(i);
                    diagonals1.remove(diagonal1);
                    diagonals2.remove(diagonal2);
                }
                return count;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(myPow(4, 2));
//        System.out.println(myPow(2, -2));
//        System.out.println(myPow(2, -2147483648));


        System.out.println(totalNQueens(4));
//        System.out.println();
//        System.out.println(totalNQueens(1));
//        System.out.println();
//        System.out.println(totalNQueens(2));
    }

    static int res = 0;
    public static int totalNQueens(int n) {
        for (int i = 0; i < n; i++) {
            boolean[] column = new boolean[n];
            List<Integer> pline = new ArrayList<>();
            List<Integer> nline = new ArrayList<>();
            column[i] = true;
            nline.add(0 - i);
            pline.add(0 + i);
            //从第0行开始，放置皇后
            dfs(1, column, pline, nline, n);
        }
        return res;
    }


    public static void dfs(int row, boolean[] column, List<Integer> pline, List<Integer> nline, int n) {
        if (row == n) {
            res++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (column[i] || pline.contains(row + i) || nline.contains(row - i)) {
                continue;
            }
            column[i] = true;
            pline.add(row + i);
            nline.add(row - i);
            dfs(row + 1, column, pline, nline, n);
            column[i] = false;
            pline.remove(pline.size() - 1);
            nline.remove(nline.size() - 1);
        }
    }
}
