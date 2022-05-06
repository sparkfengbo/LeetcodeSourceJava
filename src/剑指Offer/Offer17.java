package 剑指Offer;

public class Offer17 {
    class Solution {
        public int[] printNumbers(int n) {
            int m = (int) Math.pow(10, n) - 1;
            int[] ans = new int[m];
            for (int i = 0; i < m; i++) {
                ans[i] = i + 1;
            }
            return ans;
        }
    }

    public static void main(String[] args) {

    }


}
