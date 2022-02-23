import datastruct.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LeetCode215 {

    public static void main(String[] args) {
        System.out.println();
    }

    /**
     * 快排
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
//    public static int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];
//    }


    //基于堆排序
    public static int findKthLargest3(int[] nums, int k) {
        int n = nums.length;
        buildMaxHeap(nums, n);
        for (int i = n - 1; i >= n - k + 1; i--) {
            swap(nums, 0, i);
            maxHeapify(nums, 0, i);
        }
        return nums[0];
    }

    private static void heapSort(int[] nums) {
        int n = nums.length;
        buildMaxHeap(nums, n);
        for (int i = n - 1; i >= 0; i--) {
            swap(nums, 0, i);
            maxHeapify(nums, 0, i);
        }
    }

    private static void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    private static void maxHeapify(int[] nums, int parent, int heapSize) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int largest = parent;

        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }

        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != parent) {
            swap(nums, parent, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //基于快速选择的算法

    public static int findKthLargest2(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    static Random random = new Random();


    public static int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public static int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i ,r);
        return partition(a, l, r);
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, pivot, index - 1);
        return index - 1;
    }

}
