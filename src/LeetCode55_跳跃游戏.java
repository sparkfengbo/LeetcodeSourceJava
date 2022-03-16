import java.util.LinkedList;
import java.util.Queue;

public class LeetCode55_跳跃游戏 {

    public static void main(String[] args) {
//        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
//
//        System.out.println(maxSubArray(new int[]{-1}));
    }

    // 链接：https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int rightmost = 0;
            for (int i = 0; i < n; ++i) {
                if (i <= rightmost) {
                    rightmost = Math.max(rightmost, i + nums[i]);
                    if (rightmost >= n - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }


    class Solution_dp {
        public boolean canJump(int[] nums) {
            int n = nums.length;

            boolean[] dp = new boolean[n];
            dp[0] = true;

            for (int i = 1; i < n; i++) {
                for (int m = 0; m < i; m++) {
                    dp[i] = dp[i] || (dp[m] && (nums[m] >= i - m));
                }
            }
            return dp[n - 1];
        }
    }

    //https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/351919
    class Soluton_BFS {
        public boolean canJump(int[] nums) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[nums.length];
            queue.offer(0);
            while (!queue.isEmpty()) {
                for (int size = queue.size(); size > 0; size--) {
                    // idx is current position
                    int idx = queue.remove();
                    // if this condition is true, we can find an answer
                    if (idx >= nums.length - 1) return true;
                    // i is the next rightmost position we can reach
                    for (int i = idx + 1; i < nums.length &&
                            i <= idx + nums[idx]; i++) {
                        if (visited[i]) continue;
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }
            return false;
        }
    }


}
