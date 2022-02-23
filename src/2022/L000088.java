public class L000088 extends Template {

    public static void main(String[] args) {

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[m + n];

        int i = 0, j= 0;
        int index = 0;

        while (i < m && j < n) {
            sorted[index++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }

        while (i < m) {
            sorted[index++] = nums1[i++];
        }

        while (j < n) {
            sorted[index++] = nums2[j++];
        }

        for (i = 0; i < m + n; i++) {
            nums1[i] = sorted[i];
        }
    }
}
