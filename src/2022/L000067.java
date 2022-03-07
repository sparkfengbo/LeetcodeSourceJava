public class L000067 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
    }

    public String addBinary(String a, String b) {
        int A = a.length();
        int B = b.length();

        if (B > A) {
            return addBinary(b, a);
        }

        char[] ans = new char[A + 1];
        int ansIndex = ans.length - 1;
        int aIndex = A - 1;
        int bIndex = B - 1;

        boolean carry = false;
        while (aIndex >= 0 && bIndex >= 0) {
            int tmp = (a.charAt(aIndex--) - '0') + (b.charAt(bIndex--) - '0') + (carry ? 1 : 0);
            carry = tmp >= 2;
            ans[ansIndex--] = (char) ('0' + tmp % 2);
        }
        while (aIndex >= 0) {
            int tmp = (a.charAt(aIndex--) - '0') + (carry ? 1 : 0);
            carry = tmp >= 2;
            tmp = tmp % 2;
            ans[ansIndex--] = (char) ('0' + tmp % 2);
        }

        if (carry) {
            ans[ansIndex--] = '1';
        }
        return new String(ans, ansIndex + 1, ans.length - ansIndex - 1);
    }
}
