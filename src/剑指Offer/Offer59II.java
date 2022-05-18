package 剑指Offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Offer59II {


//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-ii-dui-lie-de-zui-da-zhi-by-leetcod/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class MaxQueue {
        Queue<Integer> queue;
        Deque<Integer> monoDeque;

        public MaxQueue() {
            queue = new LinkedList<Integer>();
            monoDeque = new LinkedList<Integer>();
        }

        public int max_value() {
            if (monoDeque.isEmpty()) {
                return -1;
            }
            return monoDeque.peekFirst();
        }

        public void push_back(int value) {
            while (!monoDeque.isEmpty() && monoDeque.peekLast() < value) {
                monoDeque.pollLast();
            }
            monoDeque.offerLast(value);
            queue.offer(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int ans = queue.poll();
            if (ans == monoDeque.peekFirst()) {
                monoDeque.pollFirst();
            }
            return ans;
        }
    }

}
