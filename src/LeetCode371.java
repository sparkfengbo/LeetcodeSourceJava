import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LeetCode371 {

    public static void main(String[] args) {

    }


    /**
     * 负数补码： 除最高位，其他位按位取反 再加1
     * <p>
     * 不考虑进位，两数和  a 异或 b
     * 考虑进位    (a & b) << 1
     */
    class Solution {

        public int getSum(int a, int b) {
            while (b != 0) {
                int carry = (a & b) << 1;
                a = a ^ b;
                b = carry;
            }
            return a;
        }
    }
}
