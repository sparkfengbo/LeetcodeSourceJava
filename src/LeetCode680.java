import utils.Utils;

public class LeetCode680 {

    public static boolean validPalindrome(String s) {
        int n = s.length();
        if (n <= 1) {
            return true;
        }

        int l = 0, r = n - 1;

        while (l < r) {
            char lchar = s.charAt(l);
            char rchar = s.charAt(r);
            if (rchar == lchar) {
                l++;
                r--;
            } else {
                boolean flag1 = true;
                boolean flag2 = true;
                for (int i = l + 1, j = r; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag1 = false;
                        break;
                    }
                }

                for (int i = l, j = r  -1; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag2 = false;
                        break;
                    }
                }

                return flag1 || flag2;
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        Utils.println(validPalindrome("aba"));
//        Utils.println(validPalindrome("abca"));
//        Utils.println(validPalindrome("abababca"));
//        Utils.println(validPalindrome("abxca"));
//        Utils.println(validPalindrome("eeccccbebaeeabebccceea")); //false
        Utils.println(validPalindrome("ebcbbececabbacecbbcbe")); //true

//        ebcbb e c  ec abba   cec bbcbe

                //
    }
}
