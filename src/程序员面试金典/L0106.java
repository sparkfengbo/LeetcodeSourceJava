package 程序员面试金典;

public class L0106 {
    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
        System.out.println((int) ('Z'));
        System.out.println((int) ('a'));
        System.out.println((int) ('~'));
    }

    public static String compressString(String S) {
        int n = S.length();
        if (n < 2) {
            return S;
        }
        StringBuilder ans = new StringBuilder();
        char[] arr = S.toCharArray();
        int slow = 0, fast = 1;
        while (fast <= n) {
            if (fast < n && arr[fast] == arr[slow]) {
                fast++;
                continue;
            } else {
                ans.append(arr[slow]);
                ans.append(fast - slow);
                slow = fast;
                fast = slow + 1;
            }
        }

        return ans.length() < n ? ans.toString() : S;
    }
}
