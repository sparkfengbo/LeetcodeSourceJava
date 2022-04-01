import sun.plugin.util.UIUtil;
import utils.Utils;

import javax.rmi.CORBA.Util;
import java.util.Arrays;

public class LeetCode135 {

    class Solution {
        public int candy(int[] ratings) {

            int n = ratings.length;
            int[] increment = new int[n];
            for (int i = 1, inc = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    increment[i] = Math.max(inc++, increment[i]);
                } else {
                    inc = 1;
                }
            }

            for (int i = n - 2, inc = 1; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    increment[i] = Math.max(inc++, increment[i]);
                } else {
                    inc = 1;
                }
            }

            int ans = n;
            for (int i = 0; i < n; i++) {
                ans += increment[i];
            }
            return ans;
        }
    }

    public static int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < ratings.length; i++)
            if (ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
        int count = left[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
            count += Math.max(left[i], right[i]);
        }
        return count;
    }

    public static void main(String[] args) {
//        int res = candy(new int[]{1,0,2});
//        Utils.println(res);
        int res2 = candy(new int[]{1, 2, 2});
        Utils.println(res2);
    }

    public static int candy2(int[] ratings) {

        int n = ratings.length;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);

        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                if (ratings[i] > ratings[i + 1]) {
                    if (candy[i] <= candy[i + 1]) {
                        candy[i] = candy[i + 1] + 1;
                        for (int j = i - 1; j >= 0; j--) {
                            if (ratings[j] > ratings[j + 1] && candy[j] <= candy[j + 1]) {
                                candy[j] = candy[j + 1] + 1;
                            }
                        }
                    }
                } else if (ratings[i] < ratings[i + 1]) {
                    candy[i + 1] = candy[i] + 1;
                }
            }
        }
        int ans = 0;
        for (Integer c : candy) {
            ans += c;
        }
        return ans;
    }
}
