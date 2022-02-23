public class L000070 extends Template {

    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        factorial[1] = 1;
        for (int i = 2; i < factorial.length; i++) {
            factorial[i] = factorial[i - 1] + factorial[i - 2];
        }
        return factorial[n];
    }
}
