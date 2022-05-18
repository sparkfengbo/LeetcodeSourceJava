package 剑指Offer;

public class Offer44 {

    class Solution {
        public int findNthDigit(int n) {
            int digit = 1;
            long start = 1;
            long count = 9;
            while (n > count) { // 1.
                n -= count;
                digit += 1;
                start *= 10;
                count = digit * start * 9;
            }
            long num = start + (n - 1) / digit; // 2.
            return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
        }
    }

//    作者：jyd
//    链接：https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/mian-shi-ti-44-shu-zi-xu-lie-zhong-mou-yi-wei-de-6/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {

    }


}
