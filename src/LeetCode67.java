public class LeetCode67 {




    public static String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        String shorter = lenA > lenB ? b : a;
        String longer = lenA > lenB ? a : b;
        int maxLen = Math.max(lenA, lenB) + 1;
        char[] ans = new char[maxLen];

        int pn = maxLen - 1;
        int s = shorter.length() - 1,  l = longer.length() -1;
        boolean carry = false;
        while (s >= 0) {
            int tmp = shorter.charAt(s) + longer.charAt(l) - '0' - '0';
            if (carry) {
                tmp++;
            }
            if (tmp / 2 >= 1) {
                carry = true;
            } else {
                carry = false;
            }
            ans[pn--] = (char)('0' + tmp % 2);
            s--;
            l--;
        }

        for (int i = l - s - 1; i >= 0; i--) {
            int tmp = longer.charAt(i) - '0';
            if (carry) {
                tmp++;
            }
            if (tmp / 2 >= 1) {
                carry = true;
            } else {
                carry = false;
            }
            ans[pn--] = (char)('0' + tmp % 2);
        }

        if (carry) {
            ans[pn--] = ('1');
        }

        return new StringBuilder().append(ans, pn + 1, maxLen - pn - 1).toString();

    }

    public static void main(String[] args) {
//        System.out.println(addBinary("11", "1"));
//        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("100", "110010"));//"110110"
    }
}
