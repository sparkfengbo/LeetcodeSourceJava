import java.util.*;


public class LeetCode503_下一个更大元素II {

    public static void main(String[] args) {

        Solution solution = new Solution();

//        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(solution
                .nextGreaterElements(new int[]{6, 5, 4, 3, 2, 1})));
    }


    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/next-greater-element-ii/solution/xia-yi-ge-geng-da-yuan-su-ii-by-leetcode-bwam/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 单调栈 + 循环数组
     */
    class Solution_leetcode {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] ret = new int[n];
            Arrays.fill(ret, -1);
            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i = 0; i < n * 2 - 1; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                    ret[stack.pop()] = nums[i % n];
                }
                stack.push(i % n);
            }
            return ret;
        }
    }


    static class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int length = nums.length;
            int max = Integer.MIN_VALUE, maxIndex;
            for (int i = 0; i < length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            Deque<Integer> stack = new LinkedList<>();
            Map<Integer, Integer> map = new HashMap<>();
            int i = 0;
            while (map.size() != length) {
                int index = i % length;
                int nextIndex = (i + 1) % length;
                int curr = nums[index];
                int next = nums[nextIndex];
                if (curr == max) {
                    map.put(index, -1);
                    i++;
                    continue;
                }
                if (next > curr) {
                    map.put(index, next);
                    while (!stack.isEmpty() && nums[stack.peek()] < next) {
                        map.put(stack.pop(), next);
                    }
                } else {
                    stack.push(index);
                }
                i++;
            }
            int[] res = new int[length];
            for (i = 0; i < length; i++) {
                res[i] = map.get(i);
            }
            return res;
        }
    }


}
