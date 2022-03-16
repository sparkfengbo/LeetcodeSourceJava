import utils.Utils;

import java.util.Arrays;

public class LeetCode1278 {


    /**
     * https://leetcode-cn.com/problems/palindrome-partitioning-iii/solution/shu-ju-jie-gou-he-suan-fa-dong-tai-gui-h-rzge/
     * @param s
     * @param k
     * @return
     */


    class Solution {
        public int palindromePartition(String s, int k) {
            int length = s.length();
            int[][] dp = new int[length + 1][k + 1];

            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], length);
            }
            //前i个字符，分割成j个回文子串
            for (int i = 1; i <= length; i++) {
                //前i个字符最大只能分割成i个子串，所以不能超过i，
                //我们取i和k的最小值
                int len = Math.min(i, k);

                for (int j = 1; j <= len; j++) {
                    if (j == 1) {
                        //如果j等于1，则表示没有分割，我们直接计算
                        dp[i][j] = change(s, j - 1, i - 1);
                    } else {
                        //如果j不等于1，我们计算分割所需要修改的最小字符数，因为m的值要
                        //大于等于j-1，我们就从最小的开始枚举
                        for (int m = j - 1; m < i; m++) {
                            //递推公式
                            dp[i][j] = Math.min(dp[i][j], dp[m][j - 1] + change(s, m, i - 1));
                        }
                    }
                }
            }
            return dp[length][k];
        }

        private int change(String s, int left, int right) {
            int count = 0;
            while(left < right) {
                if (s.charAt(left++) != s.charAt(right--)) {
                    count++;
                }
            }
            return count;
        }





    }
}
