package 剑指Offer;

import datastruct.ListNode;

public class Offer64 {

    /**
     * https://leetcode-cn.com/problems/qiu-12n-lcof/solution/qiu-12n-by-leetcode-solution/
     *
     * 注意俄罗斯农名乘法  这个可以看看，有点意思
     * @param n
     * @return
     */
    public static int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {

    }


}
