public class LeetCode34 {


    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/zai-pai-xu-shu-zu-zhong-cha-zhao-yuan-su-de-di-3-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int leftIdx = binarySearch(nums, target, true);
            int rightIdx = binarySearch(nums, target, false) - 1;
            if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
                return new int[]{leftIdx, rightIdx};
            }
            return new int[]{-1, -1};
        }

        public int binarySearch(int[] nums, int target, boolean lower) {
            int left = 0, right = nums.length - 1, ans = nums.length;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target || (lower && nums[mid] >= target)) {
                    right = mid - 1;
                    ans = mid;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }


    class Solution_2022 {
        public int[] searchRange(int[] nums, int target) {
            int[] res = {-1, -1};

            int n = nums.length;
            int left = 0, right = n;
            boolean find = false;
            while (left < right) {
                int mid = (left + right) / 2;
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
                } else if (nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            if (find) {
                left = res[0];
                right = n;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] == target) {
                        left = mid;
                        if (mid == n - 1) {
                            res[1] = mid;
                            break;
                        } else if (mid < n - 1 && nums[mid + 1] > target) {
                            res[1] = mid;
                            break;
                        }
                    } else if (nums[mid] > target) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return res;
        }

    }


    //可行，但是效率较低，搜索到target后不应该停下来，应该继续二分查找，参考 searchRange2
    public static int[] searchRange(int[] nums, int target) {
        if (nums != null) {
            int ansLeft = -1, ansRight = -1;
            int left = 0, right = nums.length - 1;

            int pivotIndex = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    pivotIndex = mid;
                    break;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            ansRight = pivotIndex;
            ansLeft = pivotIndex;
            if (pivotIndex != -1) {
                for (int i = pivotIndex + 1; i < nums.length; i++) {
                    if (nums[i] == target) {
                        ansRight++;
                    }
                }

                for (int i = pivotIndex - 1; i >= 0; i--) {
                    if (nums[i] == target) {
                        ansLeft--;
                    }
                }

                return new int[]{ansLeft, ansRight};
            }
        }
        return new int[]{-1, -1};
    }

    public static final int extremeSearchIndex(int[] nums, int target, boolean left) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }
        return low;
    }

    public static int[] searchRange2(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums != null) {
            int leftIndex = extremeSearchIndex(nums, target, true);
            if (leftIndex < 0 || leftIndex >= nums.length || nums[leftIndex] != target) {
                return ans;
            }

            ans[0] = leftIndex;
            ans[1] = extremeSearchIndex(nums, target, false) - 1;
            return ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = new int[]{5, 7, 7, 8, 8, 10};

        int[] ans = searchRange2(test, 8);

        for (Integer i : ans) {
            System.out.println(i);
        }
    }
}
