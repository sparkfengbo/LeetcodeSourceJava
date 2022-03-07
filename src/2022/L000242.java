public class L000242 extends Template {

    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m != n) {
            return false;
        }

        int[] A = new int[26];
        int[] B = new int[26];

        for (char c : s.toCharArray()) {
            A[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            B[c - 'a']++;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) {
                return false;
            }
        }
        return true;

    }
}
