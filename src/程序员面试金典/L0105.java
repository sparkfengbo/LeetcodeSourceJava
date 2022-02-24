package 程序员面试金典;

import java.util.HashMap;
import java.util.Map;

public class L0105 {
    public static void main(String[] args) {
        System.out.println(oneEditAway("abc", "ab"));
        System.out.println((int) ('B'));
        System.out.println((int) ('Z'));
        System.out.println((int) ('a'));
        System.out.println((int) ('~'));

    }

    public static boolean oneEditAway(String first, String second) {
        int n = first.length(), m = second.length();

        if (n > m) {
            return oneEditAway(second, first);
        }

        if (m - n > 1) {
            return false;
        }

        if (m == n) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    cnt++;
                    if (cnt > 1) {
                        return false;
                    }
                }
            }
            return true;
        }
        int i = 0, ofs = 0;
        while (i < n) {
            if (first.charAt(i) != second.charAt(i + ofs)) {
                if (++ofs > 1) {
                    return false;
                }
            } else {
                i++;
            }
        }
        return true;
    }
}
