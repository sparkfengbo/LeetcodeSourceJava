import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeetCode227 {

    public static void main(String[] args) {


    }
    class Solution  {
        public int calculate(String s) {
            char[] cs = s.trim().toCharArray();
            Deque<Integer> stack = new LinkedList<>();
            int i  = 0, n = cs.length;
            while(i < n) {
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
                while (i < n && Character.isDigit(cs[i])) {
                    num = num * 10 + cs[i] - '0';
                    i++;
                }
                switch (tmp) {
                    case '-':
                        num = -num;
                        break;
                    case '*':
                        num = stack.pop() * num;
                        break;
                    case '/':
                        num = stack.pop() / num;
                        break;
                    default:
                        break;
                }
                stack.push(num);
            }
            int ans = 0;
            while (!stack.isEmpty()) ans += stack.pop();
            return ans;
        }
    }

}
