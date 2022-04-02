import datastruct.ListNode;
import utils.Utils;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class LeetCode150 {


    public static void main(String[] args) {

        //9
//        Utils.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));

        //6
        Utils.println(evalRPN(new String[]{"4","13","5","/","+"}));
    }

    class Solution {
        public int evalRPN(String[] tokens) {
            int res= 0;
            Deque<Integer> stack = new LinkedList<>();
            int n = tokens.length;
            for (int i = 0; i < n; i++) {
                String s = tokens[i];
                if (s.equals("+") || s.equals("-")|| s.equals("*")|| s.equals("/") ) {
                    int a = stack.pop();
                    int b = stack.pop();
                    int r = 0;
                    switch (s) {
                        case "+":
                            r = a + b;
                            break;
                        case "-":
                            r = b - a;
                            break;
                        case "*":
                            r = a * b;
                            break;
                        case "/":
                            r = b / a;
                            break;
                    }
                    stack.push(r);
                } else {
                    stack.push(Integer.valueOf(s));
                }
            }

            return stack.isEmpty() ? 0 : stack.peek();
        }
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int N = tokens.length;
        for (int i = 0; i < N; i++) {
            if (tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (tokens[i].equals("-")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 - num2);
            } else if (tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (tokens[i].equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(num1 / num2);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
