package 剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer38 {

    class Solution {
        List<String> ans = new ArrayList<>();
        public String[] permutation(String s) {
            char[] arr = s.toCharArray() ;
            Arrays.sort(arr);
            dfs(arr, new StringBuilder(), new ArrayList<>());
            return ans.toArray(new String[ans.size()]);
        }

        private void dfs(char[] arr, StringBuilder sb, List<Integer> path) {
            if (sb.length() == arr.length) {
                ans.add(sb.toString());
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                if (path.contains(i)) {
                    continue;
                }
                if (i > 0 && path.contains(i - 1) && arr[i] == arr[i - 1]) {
                    continue;
                }
                path.add(i);
                sb.append(arr[i]);
                dfs(arr, sb, path);
                path.remove(path.size() -1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    class Solution_opt {
        List<String> ans = new ArrayList<>();
        boolean[] vis;
        public String[] permutation(String s) {
            vis = new boolean[s.length()];
            char[] arr = s.toCharArray() ;
            Arrays.sort(arr);
            dfs(arr, new StringBuilder(), vis);
            return ans.toArray(new String[ans.size()]);
        }

        private void dfs(char[] arr, StringBuilder sb, boolean[] vis) {
            if (sb.length() == arr.length) {
                ans.add(sb.toString());
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                if (vis[i]) {
                    continue;
                }
                if (i > 0 && vis[i - 1] && arr[i] == arr[i - 1]) {
                    continue;
                }
                vis[i] = true;
                sb.append(arr[i]);
                dfs(arr, sb, vis);
                vis[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }



//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/solution/zi-fu-chuan-de-pai-lie-by-leetcode-solut-hhvs/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution_leetcode {
        List<String> rec;
        boolean[] vis;

        public String[] permutation(String s) {
            int n = s.length();
            rec = new ArrayList<String>();
            vis = new boolean[n];
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            StringBuffer perm = new StringBuffer();
            backtrack(arr, 0, n, perm);
            int size = rec.size();
            String[] recArr = new String[size];
            for (int i = 0; i < size; i++) {
                recArr[i] = rec.get(i);
            }
            return recArr;
        }

        public void backtrack(char[] arr, int i, int n, StringBuffer perm) {
            if (i == n) {
                rec.add(perm.toString());
                return;
            }
            for (int j = 0; j < n; j++) {
                if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                    continue;
                }
                vis[j] = true;
                perm.append(arr[j]);
                backtrack(arr, i + 1, n, perm);
                perm.deleteCharAt(perm.length() - 1);
                vis[j] = false;
            }
        }
    }


    public static void main(String[] args) {

    }
}
