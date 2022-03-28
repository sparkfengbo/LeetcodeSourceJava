import datastruct.TreeNode;

import java.util.*;

public class LeetCode331 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.isValidSerialization("1,#,#");
    }

    static class Solution {
        public boolean isValidSerialization(String preorder) {
            int n = preorder.length();
            Deque<Integer> stack = new LinkedList<>();
            int i = 0;
            stack.push(1);

            while (i < n) {
                if (stack.isEmpty()) {
                    return false;
                }

                if (preorder.charAt(i) == ',') {
                    i++;
                } else if (preorder.charAt(i) == '#') {
                    int top = stack.pop() - 1;
                    if (top > 0) {
                        stack.push(top);
                    }
                    i++;
                } else {
                    while (i < n && preorder.charAt(i) != ',') {
                        i++;
                    }
                    int top = stack.pop() - 1;
                    if (top > 0) {
                        stack.push(top);
                    }
                    stack.push(2);
                }
            }
            return stack.isEmpty();
        }
    }
}
