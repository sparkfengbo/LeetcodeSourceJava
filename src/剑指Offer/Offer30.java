package 剑指Offer;

import java.util.HashSet;
import java.util.Stack;

public class Offer30 {

    class MinStack {
        Stack<Integer> mRawStack;
        Stack<Integer> mMinStack;

        /** initialize your data structure here. */
        public MinStack() {
            mRawStack = new Stack<>();
            mMinStack = new Stack<>();
        }

        public void push(int x) {
            if (mMinStack.isEmpty()) {
                mMinStack.push(x);
            } else {
                if (x <= mMinStack.peek()) {
                    mMinStack.push(x);
                }
            }
            mRawStack.push(x);
        }

        public void pop() {
            if (mRawStack.peek() == mMinStack.peek()) {
                mMinStack.pop();
            }
            mRawStack.pop();
        }

        public int top() {
            return mRawStack.peek();
        }

        public int min() {
            return mMinStack.peek();
        }
    }

    public static void main(String[] args) {

    }


}
