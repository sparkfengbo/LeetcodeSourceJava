package 剑指Offer;

import java.util.HashSet;
import java.util.Set;

public class Offer62 {


//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-by-lee/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution {
        public int lastRemaining(int n, int m) {
            return f(n, m);
        }

        public int f(int n, int m) {
            if (n == 1) {
                return 0;
            }
            int x = f(n - 1, m);
            return (m + x) % n;
        }
    }

//    class Solution {
//        public int lastRemaining(int n, int m) {
//            Set<Integer> deleted = new HashSet<>();
//            m = m % n;
//            int start = 0;
//            int count = m - 1;
//            while (deleted.size() != n - 1) {
//                while (count > 0) {
//                    start = (start + 1) % n;
//                    if (deleted.contains(start)) {
//                        continue;
//                    }
//                    count--;
//                }
//                deleted.add(start);
//                start = (start + 1) % n;
//                while (deleted.contains(start)) {
//                    start = (start + 1) % n;
//                }
//                count = m - 1;
//            }
//            return start;
//        }
//    }

    public static void main(String[] args) {

    }


}
