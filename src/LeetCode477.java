public class LeetCode477 {

    public static void main(String[] args) {

    }

    class Solution {
        public int hammingDistance(int x, int y) {
            int ans = 0;
            int xor = x ^ y;

            int i = 0;
            while (xor >> i != 0 ) {
                if (((xor >> i) & 1) != 0) {
                    ans++;
                }
                i++;
            }
            return ans;
        }
    }
}
