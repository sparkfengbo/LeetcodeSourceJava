package 剑指Offer;

public class Offer16_快速幂 {


    class Solution {
        public double myPow(double x, int n) {
            return n > 0 ? quickMul(x, n) : 1 / quickMul(x, -n);
        }

        private double quickMul(double x, int n) {
            if (n == 0 || x == 1) {
                return 1;
            }

            if (n == 1) {
                return x;
            }

            double r = quickMul(x, n / 2);
            double tmp = r * r;

            return n % 2 != 0 ? tmp * x : tmp;
        }
    }

    public static void main(String[] args) {

    }


}
