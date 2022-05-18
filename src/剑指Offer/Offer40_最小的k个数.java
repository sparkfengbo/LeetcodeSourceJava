package 剑指Offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Offer40_最小的k个数 {

    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(
                    (o1, o2) -> {
                        if (o1 > o2) {
                            return 1;
                        } else if (o1 < o2) {
                            return -1;
                        }
                        return 0;
                    }
            );
            for (int i = 0; i < arr.length; i++) {
                queue.add(arr[i]);
            }

            int[] r = new int[k];
            for (int i = 0; i < k; i++) {
                r[i] = queue.poll();
            }
            return r;
        }
    }



//    作者：jyd
//    链接：https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/solution/jian-zhi-offer-40-zui-xiao-de-k-ge-shu-j-9yze/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution_quicksort {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k >= arr.length) return arr;
            return quickSort(arr, k, 0, arr.length - 1);
        }

        private int[] quickSort(int[] arr, int k, int l, int r) {
            int i = l,   j = r;
            while (i < j) {
                while (i < j && arr[j] >= arr[l]) j--;
                while (i < j && arr[i] <= arr[l]) i++;
                swap(arr, i, j);
            }
            swap(arr, i, l);
            if (i > k) return quickSort(arr, k, l, i - 1);
            if (i < k) return quickSort(arr, k, i + 1, r);
            return Arrays.copyOf(arr, k);
        }
        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }



//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/solution/zui-xiao-de-kge-shu-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Solution_ {
        public int[] getLeastNumbers(int[] arr, int k) {
            randomizedSelected(arr, 0, arr.length - 1, k);
            int[] vec = new int[k];
            for (int i = 0; i < k; ++i) {
                vec[i] = arr[i];
            }
            return vec;
        }

        private void randomizedSelected(int[] arr, int l, int r, int k) {
            if (l >= r) {
                return;
            }
            int pos = randomizedPartition(arr, l, r);
            int num = pos - l + 1;
            if (k == num) {
                return;
            } else if (k < num) {
                randomizedSelected(arr, l, pos - 1, k);
            } else {
                randomizedSelected(arr, pos + 1, r, k - num);
            }
        }

        // 基于随机的划分
        private int randomizedPartition(int[] nums, int l, int r) {
            int i = new Random().nextInt(r - l + 1) + l;
            swap(nums, r, i);
            return partition(nums, l, r);
        }

        private int partition(int[] nums, int l, int r) {
            int pivot = nums[r];
            int i = l - 1;
            for (int j = l; j <= r - 1; ++j) {
                if (nums[j] <= pivot) {
                    i = i + 1;
                    swap(nums, i, j);
                }
            }
            swap(nums, i + 1, r);
            return i + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }




    public static void main(String[] args) {

    }
}
