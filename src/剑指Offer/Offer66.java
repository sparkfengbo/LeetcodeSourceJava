package 剑指Offer;

public class Offer66 {
    class Solution {
        public int[] constructArr(int[] a) {
            //左右乘积
            int m = a.length;
            int[] L = new int[m];
            int[] R = new int[m];

            int[] ans = new int[m];

            if (a.length == 0) {
                return ans;
            }
            L[0] = 1;
            for (int i = 1; i < m; i++) {
                L[i] = L[i - 1] * a[i - 1];
            }

            R[m - 1] = 1;
            for (int i = m - 2; i >= 0; i--) {
                R[i] = R[i + 1] * a[i + 1];
            }

            for (int i = 0; i < m; i++) {
                ans[i] = L[i] * R[i];
            }

            return ans;
        }
    }

    public static void main(String[] args) {

    }


}
