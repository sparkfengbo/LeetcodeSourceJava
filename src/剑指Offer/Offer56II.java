package 剑指Offer;

public class Offer56II {
    class Solution {
        public int singleNumber(int[] nums) {
            int[] digits = new int[32];

            for (int num : nums) {
                int index = 31;
                while (num != 0) {
                    if ((num & 1) != 0) {
                        digits[index]++;
                    }
                    index--;
                    num >>= 1;
                }
            }

            int result = 0;
            for (int i = 0; i < 32; i++) {
                result <<= 1;
                result |= digits[i] % 3;

            }
            return result;
        }
    }

    public static void main(String[] args) {

    }


}
