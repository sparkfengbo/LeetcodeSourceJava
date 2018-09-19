
/**
 * 反转整数
 * <p>
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class LeetCode7 {

    public static void main(String[] args) {
        //321
        System.out.println(reverse(123));
        //-321
        System.out.println(reverse(-123));
        //21
        System.out.println(reverse(120));

        System.out.println(reverse(1534236469));

    }

    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        boolean isPostive = true;
        if (x < 0) {
            isPostive = false;
        }

        String s = Integer.toString(Math.abs(x));

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        int result;
        try {
            result = isPostive ? Integer.parseInt(sb.toString()) : -Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            result = 0;
        }

        return result;
    }
}
