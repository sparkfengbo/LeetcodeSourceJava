package 剑指Offer;

import sun.awt.image.ImageWatched;

import javax.sound.sampled.Line;
import java.util.*;

public class Offer31 {

    public static void main(String[] args) {

    }
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> stack = new LinkedList<>();
            int m = popped.length;
            int popIndex = 0;
            int pushIndex = 0;

            while (pushIndex < m || popIndex < m) {
                if (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                    stack.pop();
                    popIndex++;
                    continue;
                }

                if (!stack.isEmpty() && pushIndex >= m) {
                   if (stack.peek() != popped[popIndex]) {
                       return false;
                   }
                }
                if (pushIndex < m) {
                    stack.push(pushed[pushIndex++]);
                }
            }
            return stack.isEmpty();
        }
    }


//
//    作者：jyd
//    链接：https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/solution/mian-shi-ti-31-zhan-de-ya-ru-dan-chu-xu-lie-mo-n-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution_leetcode {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int i = 0;
            for(int num : pushed) {
                stack.push(num); // num 入栈
                while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                    stack.pop();
                    i++;
                }
            }
            return stack.isEmpty();
        }
    }

}
