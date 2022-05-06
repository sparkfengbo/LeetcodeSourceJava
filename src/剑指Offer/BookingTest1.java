package 剑指Offer;

import java.util.List;

public class BookingTest1 {

    static class Result {

        /*
         * Complete the 'findNumber' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY arr
         *  2. INTEGER k
         */

        public static String findNumber(List<Integer> arr, int k) {
            if (arr == null) {
                return "NO";
            }
            boolean result = findNumber(arr, 0, arr.size() - 1, k);
            return result ? "YES" : "NO";
        }

        private static boolean findNumber(List<Integer> arr, int left, int right, int k) {
            if (left > right) {
                return false;
            }
            int mid = (left + right) / 2;
            if (arr.get(mid) == k) {
                return true;
            } else {
                return findNumber(arr, left, mid - 1, k) || findNumber(arr, mid + 1, right, k);
            }
        }

    }

    public static void main(String[] args) {

    }


}
