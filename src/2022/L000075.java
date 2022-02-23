public class L000075 extends Template {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, 2, 1, 1, 0};
        sortColors2(arr);
        for (Integer i : arr) {
            System.out.println(i);
        }
    }

    public static void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                red++;
            } else if (nums[i] == 1) {
                white++;
            } else {
                blue++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (red > 0) {
                nums[i] = 0;
                red--;
            } else if (white > 0) {
                nums[i] = 1;
                white--;
            } else if (blue > 0) {
                nums[i] = 2;
                blue--;
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
}
