import javax.management.MBeanRegistration;

public class LeetCode75 {

    public static void sortColors(int[] nums) {

        int[] countSort = new int[3];
        for (int i = 0; i < nums.length; i++) {
            countSort[nums[i]]++;
        }
        int index = 0;
        for (int i = 0;i < 3; i++) {
            while (countSort[i]-- > 0) {
                nums[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{
                2,0,2,1,1,0
        };
        sortColors(test);
        System.out.println("");
    }
}
