public class L000058 extends Template {

    public static void main(String[] args) {

    }

    public int lengthOfLastWord(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        int l = 0, r = n - 1;
        while (r >= 0 && !Character.isAlphabetic(arr[r])) {
            r--;
        }
        if (r < 0) {
            return 0;
        }

        l = r - 1;
        while (l >= 0 && Character.isAlphabetic(arr[l])) {
            l--;
        }
        return r - l;

    }
}
