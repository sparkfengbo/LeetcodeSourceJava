package 剑指Offer;

public class Offer11 {

    public int minArray(int[] numbers) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid =  l + (r - l) / 2;
            if (numbers[mid] < numbers[r]) {
                r = mid;
            } else if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else {
                r --;
            }
        }
        return numbers[l];
    }

    public static void main(String[] args) {

    }
}
