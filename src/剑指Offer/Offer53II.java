package 剑指Offer;


import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class Offer53II {

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {

    }




}
