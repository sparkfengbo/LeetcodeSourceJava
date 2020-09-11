public class LeetCode10_03 {

    public static int search(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[l] < arr[mid]) {
                if (arr[l] <= target && target <= arr[mid]){
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } else if (arr[l] > arr[mid]) {
                if(arr[l] == target) {
                    return l;
                } else if (arr[mid] < target && target <= arr[r]){
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else {
                if (arr[l] != target) {
                    l++;
                } else {
                    return l;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = new int[]{
                5,5,5,1,2,3,4,5
        };
//        System.out.println(search(test, 5));

        test = new int[]{
                15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14
        };
        System.out.println(search(test, 5));
    }
}
