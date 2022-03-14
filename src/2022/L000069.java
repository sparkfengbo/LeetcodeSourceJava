public class L000069 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2};
    }

    public int mySqrt(int x) {

        int left = 0, right = x, ans = -1 ;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                left = mid - 1;
            }
        }
        return ans;
    }

}
