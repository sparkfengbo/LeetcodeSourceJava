package 剑指Offer;

public class Offer56I {
    public static int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int i : nums) {
            ret ^= i;
        }

        int div = 1;
        //从右到左找到第一位为1的位，这个时候a、b肯定不相等
        while ((div & ret) == 0) {
            div <<= 1;
        }

        int a = 0, b = 0;
        for (int i : nums) {
            if ((div & i) == 0) {
                b ^= i;
            } else {
                a ^= i;
            }
        }

        return new int[]{a, b};
    }

    public static void main(String[] args) {

        System.out.println(singleNumbers(new int[]{4,10,2,4}));
    }


}
