package 剑指Offer;


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

    public static void main(String[] args) {

    }


}
