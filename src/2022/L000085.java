import java.util.Stack;

public class L000085 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};

        Solution solution = new Solution();

        solution.maximalRectangle(new char[][]{
                {'1', '0','1','0','0'},
                {'1', '0','1','1','1'},
                {'1', '1','1','1','1'},
                {'1', '0','0','1','0'},
        });

    }

    static class Solution {
        public int maximalRectangle(char[][] matrix) {
            int res = 0;
            int m = matrix.length;
            int n = matrix[0].length;
            int[] nums = new int[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '0') {
                        nums[j] = 0;
                    } else {
                        nums[j] += matrix[i][j] - '0';
                    }
                }
                res = Math.max(res, largestRectangleArea(nums));
            }
            return res;
        }

        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];

            Stack<Integer> monoStack = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                    monoStack.pop();
                }
                left[i] = monoStack.isEmpty() ? -1 : monoStack.peek();
                monoStack.push(i);
            }

            monoStack.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                    monoStack.pop();
                }
                right[i] = monoStack.isEmpty() ? n : monoStack.peek();
                monoStack.push(i);
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
            }

            return ans;
        }
    }

}
