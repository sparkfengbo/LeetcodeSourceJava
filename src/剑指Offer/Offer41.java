package 剑指Offer;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Offer41 {
    class MedianFinder {
        PriorityQueue<Integer> queMin;
        PriorityQueue<Integer> queMax;

        /** initialize your data structure here. */
        public MedianFinder() {
            queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
            queMax = new PriorityQueue<Integer>((a, b) -> (a - b));
        }

        public void addNum(int num) {
            if (queMin.isEmpty() || num <= queMin.peek()) {
                queMin.offer(num);
                if (queMax.size() + 1 < queMin.size()) {
                    queMax.offer(queMin.poll());
                }
            } else {
                queMax.offer(num);
                if (queMax.size() != queMin.size()) {
                    queMin.offer(queMax.poll());
                }
            }

        }

        public double findMedian() {
            if (queMin.size() != queMax.size()) {
                return queMin.peek();
            }

            return (queMin.peek() + queMax.peek()) / 2.;
        }
    }

    public static void main(String[] args) {

    }
}
