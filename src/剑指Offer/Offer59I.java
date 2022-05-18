package 剑指Offer;

import java.util.*;

public class Offer59I {
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


//
//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution__ {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
                public int compare(int[] pair1, int[] pair2) {
                    return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
                }
            });
            for (int i = 0; i < k; ++i) {
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

//    https://leetcode.cn/problems/sliding-window-maximum/solution/zhe-hui-yi-miao-dong-bu-liao-liao-de-hua-7fy5/
    class Solution__单调队列 {
        public int[] maxSlidingWindow(int[] nums, int k) {
           int len = nums.length;
           if (len == 0) {
               return nums;
           }
           int[] arr = new int[len - k + 1];
           int arr_index = 0;

           Deque<Integer> deque = new LinkedList<>();

            for (int i = 0; i < k; i++) {
                while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                    deque.removeLast();
                }
                deque.offerLast(nums[i]);
            }

            arr[arr_index++] = deque.peekFirst();
            //移动窗口
            for (int j = k; j < len; j++) {
                //对应咱们的红色情况，则是窗口的前一个元素等于队头元素
                if (nums[j - k] == deque.peekFirst()) {
                    deque.removeFirst();
                }
                while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                    deque.removeLast();
                }
                deque.offerLast(nums[j]);
                arr[arr_index++] = deque.peekFirst();
            }
            return arr;
        }
    }


}
