/**
 * 回文数
 *
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class LeetCode9 {

    public static void main(String[] args) {
//        System.out.println(isPalindrome(121));
//        System.out.println(isPalindrome(-121));
//        System.out.println(isPalindrome(1001));
//        System.out.println(isPalindrome(10));
//        System.out.println(isPalindrome(313));
//        System.out.println(isPalindrome(33133));
        System.out.println(isPalindrome(1000000001));


    }


    /**
     * 计算最高位和最低位
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        if (x == 0 || x < 10) {
            return true;
        }
//        System.out.println("x = " + x);

        int dev = 1;
        while (x / 10 / dev >= 1) {
            dev *= 10;
        }

//        System.out.println("dev = " + dev);
        while (x > 0) {
            if (x / dev != x % 10) {
                return false;
            }
            x = x % dev / 10;

//            System.out.println("x = " + x);

            dev /= 100;
        }
        return true;
    }



    /**
     *
     * 字符串解法，速度较慢
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x) {

        if (x == 0) {
            return true;
        }

        if (x < 0) {
            return false;
        }

        String str = Integer.toString(x);

        for (int i = 0 ; i < str.length() / 2; i++) {
            if (str.charAt(i) == str.charAt(str.length() - i - 1)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

}
