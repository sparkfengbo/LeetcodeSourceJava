import utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class LeetCode8 {

    //leetcode dfa
    class Solution {
        public int myAtoi(String str) {
            Automaton automaton = new Automaton();
            int length = str.length();
            for (int i = 0; i < length; ++i) {
                automaton.get(str.charAt(i));
            }
            return (int) (automaton.sign * automaton.ans);
        }


        class Automaton {
            public int sign = 1;
            public long ans = 0;
            private String state = "start";
            private Map<String, String[]> table = new HashMap<String, String[]>() {{
                put("start", new String[]{"start", "signed", "in_number", "end"});
                put("signed", new String[]{"end", "end", "in_number", "end"});
                put("in_number", new String[]{"end", "end", "in_number", "end"});
                put("end", new String[]{"end", "end", "end", "end"});
            }};

            public void get(char c) {
                state = table.get(state)[get_col(c)];
                if ("in_number".equals(state)) {
                    ans = ans * 10 + c - '0';
                    ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
                } else if ("signed".equals(state)) {
                    sign = c == '+' ? 1 : -1;
                }
            }

            private int get_col(char c) {
                if (c == ' ') {
                    return 0;
                }
                if (c == '+' || c == '-') {
                    return 1;
                }
                if (Character.isDigit(c)) {
                    return 2;
                }
                return 3;
            }
        }
    }


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
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
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
