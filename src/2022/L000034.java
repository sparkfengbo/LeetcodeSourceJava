import utils.Utils;

public class L000034 extends Template {

    public static void main(String[] args) {
//        int[] arr = new int[]{5,7,7,8,8,10};
        int[] arr = new int[]{2, 2};


//        int[] res = searchRange(arr, 8);
        int[] res = searchRange(arr, 2);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};

        int n = nums.length;
        int left = 0,  right = n;
        boolean find = false;
        while (left < right) {
            int mid =( left + right) / 2;
            if (nums[mid] == target) {
                find = true;
                right = mid;
                if (mid == 0) {
                    res[0] = 0;
                    break;
                } else if (mid > 0 && nums[mid - 1] < target) {
                    res[0] = mid;
                    break;
                }
            } else if (nums[mid] > target){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (find) {
             left = res[0];
               right = n;
            while (left < right) {
                int mid =( left + right) / 2;
                if (nums[mid] == target) {
                    left = mid;
                    if (mid == n - 1) {
                        res[1] = mid;
                        break;
                    } else if (mid < n - 1 && nums[mid + 1] > target) {
                        res[1] = mid;
                        break;
                    }
                } else if (nums[mid] > target){
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return res;
    }
}
