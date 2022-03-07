public class L000028 extends Template {

    public static void main(String[] args) {
        System.out.println();
    }

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (m < n) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }

        for (int i = 0; i <= m - n; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int A1 = i + 1;
                boolean match = true;
                for (int j = 1; j < n; j++) {
                    if (haystack.charAt(A1++) != needle.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return i;
                }
            }
        }
        return -1;
    }
}
