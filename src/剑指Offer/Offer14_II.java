package 剑指Offer;

import java.math.BigInteger;

public class Offer14_II {
    class Solution {
        public int cuttingRope(int n) {
            final int MOD = 1000000007;
            BigInteger[] dp = new BigInteger[n + 1];
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));
                }

            }
            return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
        }
    }


    class Solution_ {
        int mod = 1000000007;
        public int cuttingRope(int n) {
            if(n < 4) return n - 1;
            int a = n / 3;
            int b = n % 3;
            if(b == 0) return (int) (myPow(3, a) % mod);
            else if(b == 1) return (int) (myPow(3, a - 1) * 4 % mod);
            else return (int) (myPow(3, a) * 2 % mod);
        }

        public long myPow(long base, int num){
            long res = 1;
            while(num > 0){
                if((num & 1) == 1){
                    res *= base;
                    res %= mod;
                }
                base *= base;
                base %= mod;
                num >>= 1;
            }
            return res;
        }
    }

    public static void main(String[] args) {

        System.out.println(myPow(3, 3));
//        System.out.println(myPow(3, 1));
//        System.out.println(myPow(3, 2));
    }

    public static long myPow(long base, int num){
        int mod = 1000007;
        long res = 1;
        while(num > 0){
            if((num & 1) == 1){
                res *= base;
                res %= mod;
            }
            base *= base;
            base %= mod;
            num >>= 1;
        }
        return res;
    }


}
