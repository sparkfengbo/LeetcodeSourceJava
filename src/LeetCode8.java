import utils.Utils;

public class LeetCode8 {

    public static int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }

        boolean symbol = false;
        int startIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                continue;
            } else if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                startIndex = i +1;
                if (str.charAt(i) == '-') {
                    symbol = true;
                }
                break;
            } else if (str.charAt(i) >= '0' || str.charAt(i) <= '9') {
                startIndex = i ;
                break;
            } else {
                return 0;
            }
        }

        int endIndex = str.length();
        for (int i = startIndex; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                continue;
            } else {
                endIndex = i ;
                break;
            }
        }

        int ans = 0;
        for (int i = endIndex - 1; i >= startIndex; i--) {
            if (symbol) {
                int tmp = (int) ((str.charAt(i) - '0') * Math.pow(10, endIndex - 1 - i));
                ans -= tmp;
                if (ans > 0) {
                    ans = Integer.MIN_VALUE;
                    break;
                }
            } else {
                int tmp = (int) ((str.charAt(i) - '0') * Math.pow(10, endIndex - 1 - i));
                    ans += tmp;
                if (ans < 0) {
                    ans = Integer.MAX_VALUE;
                    break;
                }
            }
        }
        return  ans;
    }


    public static void main(String[] args) {
        Utils.println(myAtoi("42"));
        Utils.println(myAtoi("   -42"));
        Utils.println(myAtoi("4193 with words"));
        Utils.println(myAtoi("words and 987"));
        Utils.println(myAtoi("-91283472332"));
    }
}
