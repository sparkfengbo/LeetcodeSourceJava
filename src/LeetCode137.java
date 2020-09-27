import java.util.LinkedList;

public class LeetCode137 {

    public static void main(String[] args) {
        System.out.println(singleNumber1(new int[]{2,2,1}));
    }


    public static int singleNumber1(int[] nums) {
        int[] count = new int[Integer.SIZE];

        for (int i =0; i < nums.length; i++) {
            for (int j = 0; j < count.length; j++) {
                count[j] += (nums[i] >> j) & 1;
                count[j] %= 3;
            }
        }

        int result = 0;
        for (int i = 0; i < count.length; i++) {
            result += count[i] << i;
        }
        return result;
    }

}
