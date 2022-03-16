import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class LeetCode131 {

    boolean[][] f;
    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();

    int n ;
    public List<List<String>> partition(String s) {
        n = s.length();

        f = new boolean[n][n];

        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {
                int j = i + l;
                if (l == 0) {
                    f[i][j] = true;
                } else if (l == 1) {
                    f[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    f[i][j] =  s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
                }
            }
        }
        
        dfs(s, 0);
        return ret;
    }
    
    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; j++) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j+ 1);
                ans.remove(ans.size() - 1);
            }
        }
    }



}
