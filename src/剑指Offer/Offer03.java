package 剑指Offer;


import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class Offer03 {

    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    public static int findRepeatNumber2(int[] nums) {
        BitSet bitSet = new BitSet();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (bitSet.get(value)) {
                return value;
            } else {
                bitSet.set(value);
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }


}
