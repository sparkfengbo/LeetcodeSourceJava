import datastruct.TreeNode;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class LeetCode125 {

    public static boolean isPalindrome(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return true;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (left < right) {
                if (Character.toLowerCase(s.charAt(right)) != Character.toLowerCase(s.charAt(left))) {
                    return false;
                } else {
                    left++;
                    right--;
                }
            }
        }
        return true;
    }

    private static boolean isDigitOrAlphabet(char c) {
        if (Character.isDigit(c) ||
                (Character.isLowerCase(c) ||
                        Character.isUpperCase(c))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Utils.println(isPalindrome("A man, a plan, a canal: Panama"));
        Utils.println(isPalindrome("race a car"));
        Utils.println(isPalindrome(".,"));
    }
}
