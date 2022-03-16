public class LeetCode240 {


    /**
     * 每行二分查找
     */
    class Solution_binarysearch {
        public boolean searchMatrix(int[][] matrix, int target) {
            for (int[] row : matrix) {
                int index = search(row, target);
                if (index >= 0) {
                    return true;
                }
            }
            return false;
        }

        public int search(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                int num = nums[mid];
                if (num == target) {
                    return mid;
                } else if (num > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return -1;
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int r = 0, c = column - 1;
        while (r < row && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }

        return false;
    }


    public static void main(String[] args) {

    }
}
