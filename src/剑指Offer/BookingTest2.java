package 剑指Offer;

import java.util.ArrayList;
import java.util.List;

public class BookingTest2 {

    static class Result {
        /*
         * Complete the 'oddNumbers' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. INTEGER l
         *  2. INTEGER r
         */

        public static List<Integer> oddNumbers(int l, int r) {
            List<Integer> res = new ArrayList<>();
            for (int i = l; i <= r; i++) {
                if ((i & 1) == 1) {
                    res.add(i);
                }
            }
            return res;
        }

    }

    public static void main(String[] args) {

    }


}
