import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode93 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.generateParenthesis(1));
        System.out.println(solution.restoreIpAddresses("25525511135"));
        System.out.println(solution.restoreIpAddresses("0000"));
        System.out.println(solution.restoreIpAddresses("101023"));
    }

    static class Solution {
        List<String> ans = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            ans.clear();
            int l = s.length();
            if (l > 12) {
                return ans;
            }
            dfs(0, 0, s, new ArrayList<>());
            return ans;
        }

        private void dfs(int level, int startIndex, String s, List<String> path) {
            if (level == 4) {
                if (startIndex == s.length()) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < path.size() - 1; i++) {
                        sb.append(path.get(i));
                    }
                    ans.add(sb.toString());
                }
                return;
            }

            for (int l = 1; l <= 3 && startIndex + l <= s.length(); l++) {
                String n = s.substring(startIndex, startIndex + l);
                if (n.charAt(0) == '0' && l != 1) {
                    continue;
                }
                int num = Integer.parseInt(n);
                if (num >= 0 & num <= 255) {
                    path.add(n);
                    path.add(".");
                    dfs(level + 1, startIndex + l, s, path);
                    path.remove(path.size() - 1);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

}
