public class LeetCode238 {

    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            if (len == 0) return new int[]{};

            int[] L = new int[len];
            int[] R = new int[len];
            L[0] = 1;
            for (int i = 1; i < len; i++) {
                L[i] = L[i-1] * nums[i -1];
            }
            R[len - 1] = 1;
            for (int i = len - 2; i >= 0; i--) {
                R[i] = R[i+1] * nums[i + 1];
            }

            int[] ans = new int[len];
            for (int i = 0; i < len; i++) {
                ans[i] = L[i] * R[i];
            }
            return ans;
        }
    }



//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/product-of-array-except-self/solution/chu-zi-shen-yi-wai-shu-zu-de-cheng-ji-by-leetcode-/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution_leetcode {
        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            int[] answer = new int[length];

            // answer[i] 表示索引 i 左侧所有元素的乘积
            // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
            answer[0] = 1;
            for (int i = 1; i < length; i++) {
                answer[i] = nums[i - 1] * answer[i - 1];
            }

            // R 为右侧所有元素的乘积
            // 刚开始右边没有元素，所以 R = 1
            int R = 1;
            for (int i = length - 1; i >= 0; i--) {
                // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
                answer[i] = answer[i] * R;
                // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
                R *= nums[i];
            }
            return answer;
        }
    }

    public static void main(String[] args) {
    }
}
