package 程序员面试金典;

import java.util.Deque;
import java.util.LinkedList;

public class L0302 {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.top();
        System.out.println(stack.top());

    }

    static class MinStack {
        private Deque<Integer> stack;
        private Deque<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                minStack.push(x < minStack.peek() ? x : minStack.peek());
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.isEmpty() ? -1 : stack.peek();
        }

        public int getMin() {
            return minStack.isEmpty() ? -1 : minStack.peek();
        }
    }
}
