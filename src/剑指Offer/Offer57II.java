package 剑指Offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Offer57II {
    class Solution {
        public int[][] findContinuousSequence(int target) {
            List<int[]> list = new ArrayList<>();

            for (int i = 1; i <= (target - 1) /2; i++) {
                int sum = i;
                int j = i + 1;
                while (sum < target && j < target) {
                    sum += j;
                    j++;
                }
                if (sum == target) {
                    list.add(new int[]{i, j - 1});
                }
            }

            int[][] result = new int[list.size()][];
            for (int i = 0; i < list.size(); i++) {
                int[] range = list.get(i);
                int[] r = new int[range[1] - range[0] + 1];
                for (int j = 0; j < r.length; j++) {
                    r[j] = j + range[0];
                }
                result[i] = r;
            }
            return result;
        }
    }

    public static void main(String[] args) {

    }


}
