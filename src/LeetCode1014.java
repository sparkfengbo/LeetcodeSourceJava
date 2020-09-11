import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static utils.Utils.printNestList;

public class LeetCode1014 {

    /**
     * A[i] + A[j] + i - j
     * => A[i] + i    A[j] - j
     *
     * @param A
     * @return
     */
    public static int maxScoreSightseeingPair(int[] A) {
        int ans = Integer.MIN_VALUE;

        int i;
        int max = A[0];
        for (int j = 1; j < A.length; j++) {
            i = j - 1;
            max = Math.max(max, A[i] + i);
            ans = Math.max(ans, max + A[j] - j);
        }
        return ans;
    }

    public static void main(String[] args) {
//        Utils.print(maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
        Utils.print(maxScoreSightseeingPair(new int[]{1, 3, 5}));
    }
}
