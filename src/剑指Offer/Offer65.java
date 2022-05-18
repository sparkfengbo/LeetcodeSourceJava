package 剑指Offer;

import java.util.HashMap;
import java.util.Map;

public class Offer65 {
    class Solution {
        public int add(int a, int b) {
            while (b != 0) {
                int c = (a & b) << 1;
                a ^= b;
                b = c;
            }
            return a ;
        }
    }

    public static void main(String[] args) {

    }


}
