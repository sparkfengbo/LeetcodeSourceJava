public class L000125 extends Template {

    public static void main(String[] args) {
        System.out.println(isPalindrome("OP"));
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        if (n == 0 || s.equals(" ") || n == 1) {
            return true;
        }
        int l = 0, r = n - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } else if (Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return  true;
    }
}
