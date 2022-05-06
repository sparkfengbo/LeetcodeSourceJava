package 剑指Offer;

import java.util.Deque;
import java.util.LinkedList;

public class Offer10_I {

    class Solution {
        public int fib(int n) {
            if (n < 2) {
                return n;
            }

            final int MOD = 1000000007;
            int pre = 0;
            int cur = 1;
            int tmp = 0;
            for (int i = 2; i <= n; i++) {
                tmp = cur;
                cur = (cur + pre) % MOD;
                pre = tmp;
            }
            return cur;
        }
    }
}
