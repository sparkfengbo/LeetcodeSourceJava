package 程序员面试金典;

public class L0109 {
    public static void main(String[] args) {
        System.out.println();

    }
    public boolean isFlipedString2(String s1, String s2) {
        return s1.length() == s2.length() && (s2 + s2).contains(s1);
    }
    public boolean isFlipedString(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (m != n) {
            return false;
        }

        if (n == 0 && m == 0) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                boolean match = true;
                for (int j = 0; j < n; j++) {
                    if (s2.charAt(j) != s1.charAt((i + j) % n)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}
