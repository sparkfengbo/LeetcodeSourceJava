package 剑指Offer;

import java.util.Deque;
import java.util.LinkedList;

public class Offer09 {

    class CQueue {
        private Deque<Integer> headStack;
        private Deque<Integer> tailStack;

        public CQueue() {
            headStack = new LinkedList<>();
            tailStack = new LinkedList<>();
        }

        public void appendTail(int value) {
            tailStack.push(value);
        }

        public int deleteHead() {
            if (tailStack.isEmpty() && headStack.isEmpty()) {
                return -1;
            }

            if (!headStack.isEmpty()) {
                return headStack.pop();
            }

            while (!tailStack.isEmpty() ) {
                headStack.push(tailStack.pop());
            }
            return headStack.pop();
        }
    }
}
