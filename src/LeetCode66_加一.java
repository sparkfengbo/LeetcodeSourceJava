public class LeetCode66_加一 {

    public static void main(String[] args) {
        System.out.print(plusOne(new int[]{9}));
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        boolean carry = false;
        for (int i = n - 1; i >= 0; i--) {
            digits[i] += 1;
            carry = digits[i] >= 10;
            digits[i] %= 10;
            if (!carry) {
                return digits;
            }
        }
        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}
