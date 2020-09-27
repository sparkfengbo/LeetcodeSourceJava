public class LeetCode38 {

    public static void main(String[] args) {
        System.out.println(countAndSay("1"));
        System.out.println(countAndSay("11"));
        System.out.println(countAndSay("21"));

        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        String ans = "1";

        if (n == 1) {
            return ans;
        }

        for(int i = 2; i <= n; i++) {
            ans = countAndSay(ans);
        }
        return ans;
    }

    public static String countAndSay(String s) {
        StringBuilder sb = new StringBuilder();
        int N  = s.length();
        for (int L = 0,  R = 0; R <= N; R++) {
            if (R < N && s.charAt(R) != s.charAt(L)){
                sb.append(R - L).append(s.charAt(L));
                L = R;
            }

            if (R == N) {
                sb.append(R - L).append(s.charAt(L));
            }
        }
        return sb.toString();
    }
}
