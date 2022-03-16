import datastruct.ListNode;

import java.util.*;

public class LeetCode22 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.generateParenthesis(1));
        System.out.println(solution.generateParenthesis(2));
    }

    static class Solution {

        List<String> ans = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            int lPCount = n;
            int rPCount = n;
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder("(");
            stack.push('(');
            dfs(1, n, sb, stack, lPCount - 1, rPCount);
            return ans;
        }

        private void dfs(int k, int n, StringBuilder path, Stack<Character> stack, int lPCount, int rPCount) {
            if (k == n * 2 && stack.isEmpty()) {
                ans.add(path.toString());
                return;
            }

//            for (int i = k; i < n * 2; i++) {
                if (lPCount > 0) {
                    path.append('(');
                    stack.push('(');
                    dfs(k + 1, n, path, stack, lPCount - 1, rPCount);
                    path.deleteCharAt(path.length() - 1);
                    stack.pop();
                }

                if (rPCount > 0) {
                    if (!stack.isEmpty()) {
                        path.append(')');
                        char top = stack.peek();
                        stack.pop();
                        dfs(k + 1, n, path, stack, lPCount, rPCount - 1);
                        path.deleteCharAt(path.length() - 1);
                        stack.push(top);
                    }
//                }
            }
        }
    }

}
