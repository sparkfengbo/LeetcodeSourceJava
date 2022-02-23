import java.util.LinkedList;

public class LeetCode137 {

    public static void main(String[] args) {
        System.out.println(singleNumber1(new int[]{2,2,1}));
    }


    public static int singleNumber1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += (num >> i) & 1;
            }

            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

}
