public class L000050 extends Template {

    public static void main(String[] args) {
       System.out.println(myPow(2, 10)
       );
    }

    public static double myPow(double x, int n) {
        if (n == 1) {
            return x;
        } else if (n == 0) {
            return 1;
        } else if (n == -1) {
            return 1 / x;
        }

        if ((n & 1) == 1) {
            double tmp = myPow(x, n >> 1);
            return  tmp * tmp * x;
        } else {
            double tmp = myPow(x, n >> 1);
            return  tmp * tmp;
        }
    }
}
