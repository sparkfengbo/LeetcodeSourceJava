import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode852 {

    //太慢了 参考peakIndexInMountainArray2
    public static int peakIndexInMountainArray(int[] A) {
        int[] ans = binarySearch(A, 0, A.length, Integer.MIN_VALUE);
        return ans[0];
    }

    private static int[] binarySearch(int[] A, int left, int right, int max) {
        int[] ans = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (max < A[mid]) {
                max = A[mid];
                ans[0] = mid;
                ans[1] = max;
            }
            int lAns[] = binarySearch(A, left, mid , max);
            if (max < lAns[1]) {
                max = lAns[1];
                ans[0] = lAns[0];
                ans[1] = max;
            }
            int rAns[] = binarySearch(A, mid + 1, right, max);
            if (max < rAns[1]) {
                max = rAns[1];
                ans[0] = rAns[0];
                ans[1] = max;
            }
        }
        return ans;
    }

    public static int peakIndexInMountainArray2(int[] A) {
        int low = 0, high = A.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] < A[mid + 1])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] test = new int[]{
                0,1,0
        };
//        System.out.println(peakIndexInMountainArray(test));

        test = new int[]{
                0,2,1,0
        };
        System.out.println(peakIndexInMountainArray(test));
    }
}
