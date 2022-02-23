public class LeetCode66_加一 {

    public static void main(String[] args) {
        System.out.print(plusOne(new int[]{9}));
    }

    public static int[] plusOne(int[] digits) {

        boolean carry = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += 1;
            carry = digits[i] >= 10;
            digits[i] %= 10;
            if (!carry) {
                return digits;
            }
        }
        if (carry) {
            int[] ans = new int[digits.length + 1];
            System.arraycopy(digits, 0, ans, 1, digits.length);
            ans[0] = 1;
            return ans;
        }
        return digits;
    }
}
