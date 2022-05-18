import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LeetCode217 {

    public static void main(String[] args) {
        System.out.println();
    }

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            for (int x : nums) {
                if (!set.add(x)) {
                    return true;
                }
            }
            return false;
        }
    }

}
