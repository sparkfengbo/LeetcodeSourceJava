/**
 * 2的幂
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 *
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 *
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 */
public class LeetCode231 {

    public static void main(String[] args) {
//        System.out.println(isPowerOfTwo(1));
//        System.out.println(isPowerOfTwo(16));
//        System.out.println(isPowerOfTwo(218));

        System.out.println(isPowerOfTwo(16777217));
    }

    public boolean isPowerOfTwo_2022(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & -n) == n;
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        } else if (n == 0) {
            return false;
        }

        double fNum = (double)n;

        while (fNum % 2 == 0) {
            fNum /= 2.0;
            if (fNum == 1) {
                return true;
            }
        }
        return false;
    }
}
