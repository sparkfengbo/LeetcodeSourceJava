import java.util.HashMap;
import java.util.HashSet;

public class LeetCode33_搜索旋转排序数组 {

    /**
     * 􏴑􏳋􏳼􏰸􏰻􏲛􏲜􏸄􏳩􏰿􏰾􏸅􏸆􏸇􏸈􏰮􏶌􏱨􏴑􏳋􏳼􏰸􏰻􏲛􏲜􏸄􏳩􏰿􏰾􏸅􏸆􏸇􏸈􏰮􏶌􏱨􏴑􏳋􏳼􏰸􏰻􏲛􏲜􏸄􏳩􏰿􏰾􏸅􏸆􏸇􏸈􏰮􏶌􏱨􏰨􏴑􏳋􏳼􏰸􏰻􏲛􏲜􏸄􏳩􏰿􏰾􏸅􏸆􏸇􏸈􏰮􏶌􏱨􏰨􏴑􏳋􏳼􏰸􏰻􏲛􏲜􏸄􏳩􏰿􏰾􏸅􏸆􏸇􏸈􏰮􏶌􏱨􏰨􏴑􏳋􏳼􏰸􏰻􏲛􏲜􏸄􏳩􏰿􏰾􏸅􏸆􏸇􏸈􏰮􏶌􏱨􏰨􏴑􏳋􏳼􏰸􏰻􏲛􏲜􏸄􏳩􏰿􏰾􏸅􏸆􏸇􏸈􏰮􏶌􏱨􏰨 数组 + 二分查找，难度在于边界确定
     * 􏲋􏶖􏵌􏵍􏲜 时间O(log n)􏰻􏶕􏶖􏵌􏵍􏲜 空间O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        int l = 0, r = nums.length;
        int mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid] ){
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r - 1]){
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] test = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] test2 = new int[]{3, 1};
//        System.out.println(search(test, 0));
        System.out.println(search(test2, 1));
    }
}
