import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class LeetCode51 {

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
        for (int i = 0; i < n; i++) {
            boolean[] column = new boolean[n];
            List<Integer> pline = new ArrayList<>();
            List<Integer> nline = new ArrayList<>();
            column[i] = true;
            nline.add(0 - i);
            pline.add(0 + i);
            List<Integer> path = new ArrayList<>();
            path.add(i);
            //从第0行开始，放置皇后
            dfs(1, column, pline, nline, n, path, res);
        }
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
