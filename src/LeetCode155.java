import java.util.*;

/**
 * 最小栈
 * <p>
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class LeetCode155 {

    public static void main(String[] args) {

//        MinStack minStack = new MinStack();
//        minStack.push(-3);
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//
//        //返回 -3.
//        System.out.println(minStack.getMin());
//
//        minStack.pop();
//        //返回 0.
//        System.out.println(minStack.top());
//        //返回 -2.
//        System.out.println(minStack.getMin());

        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);

        minStack.pop();

        //返回  -1024
        System.out.println(minStack.getMin());

        minStack.pop();

        //返回  -1024
        System.out.println(minStack.getMin());

        minStack.pop();

        //返回  512
        System.out.println(minStack.getMin());

    }

    static class MinStack {
        private Stack<Integer> mRawStack;

        private Stack<Integer> mMinStack;

        /**
         * initialize your data structure here.
         */
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
            if (mRawStack.peek().equals(mMinStack.peek())) {
                mMinStack.pop();
            }
            mRawStack.pop();
        }

        public int top() {
            return mRawStack.peek();
        }

        public int getMin() {
            return mMinStack.peek();
        }
    }

//    static class MinStack {
//        private ArrayDeque<Integer> mQueue;
//
//        /**
//         * initialize your data structure here.
//         */
//        public MinStack() {
//            mQueue = new ArrayDeque<>();
//        }
//
//        public void push(int x) {
//            mQueue.push(x);
//        }
//
//        public void pop() {
//            mQueue.pollFirst();
//        }
//
//        public int top() {
//            return mQueue.getFirst();
//        }
//
//        public int getMin() {
//            int min = Integer.MAX_VALUE;
//            Iterator<Integer> integerIterator = mQueue.iterator();
//            while (integerIterator.hasNext()) {
//                int next = integerIterator.next();
//                min = min < next ? min : next;
//            }
//            return min;
//        }
//    }


}
