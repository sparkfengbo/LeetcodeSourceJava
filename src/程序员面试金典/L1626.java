package 程序员面试金典;

import java.util.Deque;
import java.util.LinkedList;

public class L1626 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.calculate("3+2*2"));
//        System.out.println(solution.calculate(" 3/2 "));
//        System.out.println(solution.calculate(" 3+5 / 2 "));
//        System.out.println(solution.calculate("1+1+1"));
        System.out.println(solution.calculate("1-1+1"));


    }

    static class Solution {
        int ADD = -4;
        int MINUS = -3;
        int MULTI = -2;
        int DIVIDE = -1;

        public int calculate(String s) {
            Deque<Integer> stack = new LinkedList<>();
            int n = s.length();
            int i = 0;
            while (i < n) {
                if (Character.isDigit(s.charAt(i))) {
                    int val = 0;
                    while (i < n && Character.isDigit(s.charAt(i))) {
                        val = val * 10 + Character.getNumericValue(s.charAt(i));
                        i++;
                    }
                    if (!stack.isEmpty() && (stack.peek() == MULTI || stack.peek() == DIVIDE)) {
                        int op = stack.pop();
                        int num = stack.pop();
                        if (op == MULTI) {
                            stack.push(val * num);
                        } else {
                            stack.push(num / val);
                        }
                    } else {
                        stack.push(val);
                    }
                } else {
                    if (s.charAt(i) == '+') {
                        stack.push(ADD);
                    } else if (s.charAt(i) == '-') {
                        stack.push(MINUS);
                    } else if (s.charAt(i) == '*') {
                        stack.push(MULTI);
                    } else if (s.charAt(i) == '/') {
                        stack.push(DIVIDE);
                    }
                    i++;
                }
            }

            int res = 0;

            while (!stack.isEmpty()) {
                if (stack.size() >= 3) {
                    int num1 = stack.pollLast();
                    int op = stack.pollLast();
                    int num2 = stack.pollLast();

                    boolean isEnd = false;
                    if (stack.isEmpty()) {
                        isEnd = true;
                    }

                    if (op == ADD) {
                        stack.offerLast(res = num1 + num2);
                    } else {
                        stack.offerLast(res = num2 - num1);
                    }

                    if (isEnd) {
                        break;
                    }
                } else {
                    res = stack.pop();
                    break;
                }
            }
            return res;
        }
    }

    class Solution_ {
        public int calculate(String s) {
            char[] cs = s.trim().toCharArray();
            Deque<Integer> st = new LinkedList<>();
            int ans = 0, i = 0;
            while (i < cs.length) {
                if (cs[i] == ' ') {
                    i++;
                    continue;
                }
                char tmp = cs[i];
                if (tmp == '*' || tmp == '/' || tmp == '+' || tmp == '-') {
                    i++;
                    while (i < cs.length && cs[i] == ' ') i++;
                }
                int num = 0;
                while (i < cs.length && Character.isDigit(cs[i])) {
                    num = num * 10 + cs[i] - '0';
                    i++;
                }
                switch (tmp) {
                    case '-':
                        num = -num;
                        break;
                    case '*':
                        num = st.pop() * num;
                        break;
                    case '/':
                        num = st.pop() / num;
                        break;
                    default:
                        break;
                }
                st.push(num);
            }
            while (!st.isEmpty()) ans += st.pop();
            return ans;
        }


    }

}
