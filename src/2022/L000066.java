import com.sun.tools.javac.code.Attribute;

public class L000066 extends Template {

    public static void main(String[] args) {

    }

    public static int[] plusOne(int[] digits) {
        boolean carry = false;
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            digits[i] += 1;
            carry = digits[i] >= 10;
            if (!carry) {
                return digits;
            } else {
                digits[i] %= 10;
            }
        }

        if (carry) {
            int[] arr = new int[n + 1];
            arr[0] = 1;
            for (int i = 0; i < n; i++) {
                arr[i + 1] = digits[i];
            }
            return arr;
        }
        return digits;
    }
}
