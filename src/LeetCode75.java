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


    /**
     * 单指针
     *
     * @param nums
     */
    public static void sortColors2(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                swap(nums, i, ptr);
                ++ptr;
            }
        }
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                swap(nums, i, ptr);
                ++ptr;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 双指针
     * @param nums
     */
    public static void sortColors3(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                p0++;
                p1++;
            } else if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
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
