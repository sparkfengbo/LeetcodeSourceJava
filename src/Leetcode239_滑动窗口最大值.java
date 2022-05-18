import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode239_滑动窗口最大值 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0) {
                return new int[]{};
            }
            int n = nums.length;
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] x, int[] e) {
                    return x[0] != e[0] ? e[0] - x[0] : e[1] - x[1];
                }
            });

            for (int i = 0; i < k; i++) {
                pq.offer(new int[]{nums[i], i});
            }

            int[] ans = new int[n - k + 1];
            ans[0] = pq.peek()[0];
            for (int i = k; i < n; ++i) {
                pq.offer(new int[]{nums[i], i});
                while (pq.peek()[1] <= i - k) {
                    pq.poll();
                }
                ans[i - k + 1] = pq.peek()[0];
            }
            return ans;
        }
    }

}
