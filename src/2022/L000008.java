import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L000008 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
    }

    public int myAtoi(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        boolean symbol = false;
        int startIndex = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                continue;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                startIndex = i + 1;
                if (s.charAt(i) == '-') {
                    symbol = true;
                }
                break;
            } else if (s.charAt(i) >= '0' || s.charAt(i) <= '9') {
                startIndex = i;
                break;
            } else {
                return 0;
            }
        }

        int endIndex = n;
        for (int i = startIndex; i < n; i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                continue;
            } else {
                endIndex = i;
                break;
            }
        }

        int ans = 0;
        for (int i = endIndex - 1; i >= startIndex; i--) {
            int tmp = (int) ((s.charAt(i) - '0') * Math.pow(10, endIndex - 1 - i));
            if (symbol) {
                ans -= tmp;
                if (ans > 0) {
                    ans = Integer.MIN_VALUE;
                    break;
                }
            } else {
                ans += tmp;
                if (ans < 0) {
                    ans = Integer.MAX_VALUE;
                    break;
                }
            }

        }
        return ans;
    }
}
