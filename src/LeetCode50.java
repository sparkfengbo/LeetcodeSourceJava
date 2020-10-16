
public class LeetCode50 {

    public static void main(String[] args) {
//        System.out.println(myPow(4, 2));
//        System.out.println(myPow(2, -2));
//        System.out.println(myPow(2, -2147483648));
    }

    public static double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double tmp  = myPow2(x, Math.abs(n) / 2);
        double r = tmp * tmp * (Math.abs(n) % 2 == 0 ? 1 : x);
        return n < 0 ? 1 / r : r;
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
}
